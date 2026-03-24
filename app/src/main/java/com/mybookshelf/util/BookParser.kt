package com.mybookshelf.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.zip.ZipInputStream

sealed class BookContent {
    data class TextContent(val pages: List<String>) : BookContent()
    data class PdfPages(val totalPages: Int, val renderPage: suspend (Int) -> Bitmap?) : BookContent()
    data class EpubContent(
        val chapters: List<Chapter>,
        val toc: List<TocItem>
    ) : BookContent()
}

data class Chapter(val title: String, val content: String, val order: Int)
data class TocItem(val title: String, val chapterIndex: Int, val level: Int)

class BookParser(private val context: Context) {

    suspend fun parseBook(filePath: String, format: String): Result<BookContent> = withContext(Dispatchers.IO) {
        try {
            val uri = Uri.parse(filePath)
            when (format.uppercase()) {
                "PDF" -> parsePdf(uri)
                "EPUB" -> parseEpub(uri)
                "TXT", "MOBI", "AZW3" -> parseText(uri)
                else -> Result.failure(Exception("Unsupported format: $format"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun parsePdf(uri: Uri): Result<BookContent> {
        val parcelFileDescriptor = context.contentResolver.openFileDescriptor(uri, "r")
            ?: return Result.failure(Exception("Cannot open PDF file"))

        val renderer = PdfRenderer(parcelFileDescriptor)
        val total = renderer.pageCount
        return Result.success(BookContent.PdfPages(total) { pageIndex ->
            try {
                if (pageIndex < 0 || pageIndex >= total) {
                    null
                } else {
                    val page = renderer.openPage(pageIndex)
                    val bitmap = Bitmap.createBitmap(
                        page.width * 2,
                        page.height * 2,
                        Bitmap.Config.ARGB_8888
                    )
                    page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                    page.close()
                    bitmap
                }
            } catch (e: Exception) {
                null
            }
        })
    }

    private fun parseText(uri: Uri): Result<BookContent> {
        val inputStream = context.contentResolver.openInputStream(uri)
            ?: return Result.failure(Exception("Cannot open file"))
        
        val reader = BufferedReader(InputStreamReader(inputStream))
        val content = reader.readText()
        reader.close()

        val pages = splitIntoPages(content, 2000)
        return Result.success(BookContent.TextContent(pages))
    }

    private fun parseEpub(uri: Uri): Result<BookContent> {
        val inputStream = context.contentResolver.openInputStream(uri)
            ?: return Result.failure(Exception("Cannot open EPUB file"))

        val manifest = mutableMapOf<String, String>()
        val spine = mutableListOf<String>()
        var rootFilePath = ""
        val entryContents = mutableMapOf<String, ByteArray>()
        val toc = mutableListOf<TocItem>()

        ZipInputStream(inputStream).use { zip ->
            var entry = zip.nextEntry
            while (entry != null) {
                val entryName = entry.name
                val content = zip.readBytes()
                entryContents[entryName] = content
                
                val lowerName = entryName.lowercase()
                if (lowerName.endsWith(".opf")) {
                    rootFilePath = entryName.substringBeforeLast("/", "")
                    parseOpf(content.toString(Charsets.UTF_8), manifest, spine)
                }
                
                zip.closeEntry()
                entry = zip.nextEntry
            }
        }

        val navEntry = manifest.entries.find { it.value == "nav" || it.key.contains("nav", ignoreCase = true) }
        navEntry?.let { nav ->
            val navContent = entryContents[nav.key] ?: entryContents.entries.find { it.key.endsWith(nav.value) }?.value
            navContent?.let {
                val doc = Jsoup.parse(it.toString(Charsets.UTF_8))
                val navElement = doc.selectFirst("nav")
                navElement?.select("a")?.forEachIndexed { idx, link ->
                    val title = link.text()
                    if (title.isNotBlank()) {
                        toc.add(TocItem(title, idx, link.parents().size))
                    }
                }
            }
        }

        val chapters = mutableListOf<Chapter>()
        for ((idx, itemId) in spine.withIndex()) {
            val itemPath = manifest[itemId] ?: manifest.entries.find { it.key == itemId }?.value
            itemPath?.let { path ->
                val content = entryContents[path] ?: entryContents.entries.find { it.key.endsWith(path) }?.value
                content?.let {
                    val doc = Jsoup.parse(it.toString(Charsets.UTF_8))
                    val text = doc.body().text()
                    if (text.isNotBlank()) {
                        chapters.add(Chapter(
                            title = path.substringAfterLast("/").substringBeforeLast("."),
                            content = text,
                            order = chapters.size
                        ))
                    }
                }
            }
        }

        return if (chapters.isNotEmpty()) {
            Result.success(BookContent.EpubContent(chapters, toc))
        } else {
            Result.failure(Exception("Could not parse EPUB content"))
        }
    }

    private fun parseOpf(opfContent: String, manifest: MutableMap<String, String>, spine: MutableList<String>) {
        val doc: Document = Jsoup.parse(opfContent)
        
        doc.select("manifest item").forEach { item ->
            val id = item.attr("id")
            val href = item.attr("href")
            val mediaType = item.attr("media-type")
            manifest[id] = href
        }

        doc.select("spine itemref").forEach { ref ->
            val idref = ref.attr("idref")
            if (idref.isNotBlank()) {
                spine.add(idref)
            }
        }
    }

    private fun splitIntoPages(content: String, charsPerPage: Int): List<String> {
        if (content.length <= charsPerPage) {
            return listOf(content.ifBlank { "No content available" })
        }

        val pages = mutableListOf<String>()
        val paragraphs = content.split("\n\n")
        var currentPage = StringBuilder()
        var currentLength = 0

        for (paragraph in paragraphs) {
            if (currentLength + paragraph.length > charsPerPage && currentPage.isNotEmpty()) {
                pages.add(currentPage.toString().trim())
                currentPage.clear()
                currentLength = 0
            }
            currentPage.append(paragraph).append("\n\n")
            currentLength += paragraph.length + 2
        }

        if (currentPage.isNotEmpty()) {
            pages.add(currentPage.toString().trim())
        }

        return pages.ifEmpty { listOf(content) }
    }
}
