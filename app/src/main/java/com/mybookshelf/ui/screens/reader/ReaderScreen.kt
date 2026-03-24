package com.mybookshelf.ui.screens.reader

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mybookshelf.domain.model.Bookmark
import com.mybookshelf.domain.model.Note
import com.mybookshelf.util.BookContent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderScreen(
    bookId: Long,
    onBack: () -> Unit,
    viewModel: ReaderViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    var showBookmarks by remember { mutableStateOf(false) }
    var showNotes by remember { mutableStateOf(false) }
    var showAddBookmarkDialog by remember { mutableStateOf(false) }
    var showAddNoteDialog by remember { mutableStateOf(false) }
    var showTranslateDialog by remember { mutableStateOf(false) }

    LaunchedEffect(bookId) {
        viewModel.loadBook(bookId)
    }

    Scaffold(
        topBar = {
            AnimatedVisibility(visible = uiState.showToolbar) {
                TopAppBar(
                    title = {
                        Text(
                            text = uiState.book?.title ?: "Reader",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                    actions = {
                        IconButton(onClick = { showAddBookmarkDialog = true }) {
                            Icon(Icons.Default.Bookmark, contentDescription = "Add Bookmark")
                        }
                        IconButton(onClick = { showBookmarks = !showBookmarks }) {
                            Icon(Icons.Default.Bookmarks, contentDescription = "Bookmarks")
                        }
                        IconButton(onClick = { showNotes = !showNotes }) {
                            Icon(Icons.Default.Note, contentDescription = "Notes")
                        }
                        IconButton(onClick = { showTranslateDialog = true }) {
                            Icon(Icons.Default.Translate, contentDescription = "Translate")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        }
    ) { padding ->
        if (uiState.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    when (val content = uiState.bookContent) {
                        is BookContent.PdfPages -> PdfReaderContent(
                            content = content,
                            currentPage = uiState.currentPage,
                            onPageChange = viewModel::updatePage,
                            onTextSelected = viewModel::setSelectedText,
                            onToggleToolbar = viewModel::toggleToolbar
                        )
                        is BookContent.TextContent -> TextReaderContent(
                            pages = content.pages,
                            currentPage = uiState.currentPage,
                            onPageChange = viewModel::updatePage,
                            onTextSelected = viewModel::setSelectedText,
                            onToggleToolbar = viewModel::toggleToolbar
                        )
                        is BookContent.EpubContent -> EpubReaderContent(
                            chapters = content.chapters,
                            currentChapter = uiState.currentPage,
                            onChapterChange = viewModel::updatePage,
                            onTextSelected = viewModel::setSelectedText,
                            onToggleToolbar = viewModel::toggleToolbar
                        )
                        else -> Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(uiState.error ?: "Select a book to read")
                        }
                    }

                    if (showBookmarks) {
                        BookmarksPanel(
                            bookmarks = uiState.bookmarks,
                            onBookmarkClick = { bookmark ->
                                viewModel.updatePage(bookmark.position)
                                showBookmarks = false
                            },
                            onDelete = viewModel::deleteBookmark,
                            onDismiss = { showBookmarks = false }
                        )
                    }

                    if (showNotes) {
                        NotesPanel(
                            notes = uiState.notes,
                            onNoteClick = { note ->
                                viewModel.updatePage(note.position)
                                showNotes = false
                            },
                            onDelete = viewModel::deleteNote,
                            onAddNote = { showAddNoteDialog = true },
                            onDismiss = { showNotes = false }
                        )
                    }
                }

                if (uiState.selectedText.isNotEmpty()) {
                    TextSelectionBar(
                        text = uiState.selectedText,
                        translatedText = uiState.translatedText,
                        onCopy = {
                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText("Selected Text", uiState.selectedText)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show()
                        },
                        onTranslate = { showTranslateDialog = true },
                        onClear = { viewModel.setSelectedText("") }
                    )
                }
            }
        }
    }

    if (showAddBookmarkDialog) {
        AlertDialog(
            onDismissRequest = { showAddBookmarkDialog = false },
            title = { Text("Add Bookmark") },
            text = {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Bookmark Title (optional)") },
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.addBookmark("Page ${uiState.currentPage}")
                        showAddBookmarkDialog = false
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAddBookmarkDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showAddNoteDialog) {
        var noteContent by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { showAddNoteDialog = false },
            title = { Text("Add Note") },
            text = {
                OutlinedTextField(
                    value = noteContent,
                    onValueChange = { noteContent = it },
                    label = { Text("Note content") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    maxLines = 5
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.addNote(noteContent)
                        showAddNoteDialog = false
                    },
                    enabled = noteContent.isNotBlank()
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAddNoteDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showTranslateDialog) {
        var targetLang by remember { mutableStateOf("en") }
        AlertDialog(
            onDismissRequest = { showTranslateDialog = false },
            title = { Text("Translate") },
            text = {
                Column {
                    Text("Translate '${uiState.selectedText}' to:")
                    Spacer(modifier = Modifier.height(8.dp))
                    LanguageSelector(selectedLang = targetLang, onLangChange = { targetLang = it })
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.translateText("", targetLang)
                        showTranslateDialog = false
                    }
                ) {
                    Text("Translate")
                }
            },
            dismissButton = {
                TextButton(onClick = { showTranslateDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun TextReaderContent(
    pages: List<String>,
    currentPage: Int,
    onPageChange: (Int) -> Unit,
    onTextSelected: (String) -> Unit,
    onToggleToolbar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = onToggleToolbar)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            if (pages.isNotEmpty() && currentPage < pages.size) {
                SelectionContainer {
                    Text(
                        text = pages[currentPage],
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            } else {
                Text("No content available")
            }
        }
        
        PageNavigation(
            currentPage = currentPage,
            totalPages = pages.size,
            onPageChange = onPageChange
        )
    }
}

@Composable
fun PdfReaderContent(
    content: BookContent.PdfPages,
    currentPage: Int,
    onPageChange: (Int) -> Unit,
    onTextSelected: (String) -> Unit,
    onToggleToolbar: () -> Unit
) {
    var bitmap by remember { mutableStateOf<android.graphics.Bitmap?>(null) }
    val scope = rememberCoroutineScope()
    
    LaunchedEffect(currentPage) {
        scope.launch(Dispatchers.IO) {
            bitmap = content.renderPage(currentPage)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = onToggleToolbar)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            bitmap?.let { bmp ->
                Image(
                    bitmap = bmp.asImageBitmap(),
                    contentDescription = "PDF Page ${currentPage + 1}",
                    modifier = Modifier.fillMaxSize()
                )
            } ?: Text("Loading page...")
        }
        
        PageNavigation(
            currentPage = currentPage,
            totalPages = content.totalPages,
            onPageChange = onPageChange
        )
    }
}

@Composable
fun EpubReaderContent(
    chapters: List<com.mybookshelf.util.Chapter>,
    currentChapter: Int,
    onChapterChange: (Int) -> Unit,
    onTextSelected: (String) -> Unit,
    onToggleToolbar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = onToggleToolbar)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            if (chapters.isNotEmpty() && currentChapter < chapters.size) {
                SelectionContainer {
                    Column {
                        Text(
                            text = chapters[currentChapter].title,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = chapters[currentChapter].content,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            } else {
                Text("No chapters available")
            }
        }
        
        PageNavigation(
            currentPage = currentChapter,
            totalPages = chapters.size,
            onPageChange = onChapterChange
        )
    }
}

@Composable
fun PageNavigation(
    currentPage: Int,
    totalPages: Int,
    onPageChange: (Int) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { if (currentPage > 0) onPageChange(currentPage - 1) },
                enabled = currentPage > 0
            ) {
                Icon(Icons.Default.ChevronLeft, contentDescription = "Previous")
            }
            Text("Page ${currentPage + 1} / $totalPages")
            IconButton(
                onClick = { if (currentPage < totalPages - 1) onPageChange(currentPage + 1) },
                enabled = currentPage < totalPages - 1
            ) {
                Icon(Icons.Default.ChevronRight, contentDescription = "Next")
            }
        }
    }
}

@Composable
fun BookmarksPanel(
    bookmarks: List<Bookmark>,
    onBookmarkClick: (Bookmark) -> Unit,
    onDelete: (Bookmark) -> Unit,
    onDismiss: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(0.4f)
            .fillMaxHeight(),
        shadowElevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Bookmarks", style = MaterialTheme.typography.titleMedium)
                IconButton(onClick = onDismiss) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            if (bookmarks.isEmpty()) {
                Text(
                    "No bookmarks yet",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            } else {
                LazyColumn {
                    items(bookmarks, key = { it.id }) { bookmark ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onBookmarkClick(bookmark) }
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Default.Bookmark,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                bookmark.title,
                                modifier = Modifier.weight(1f),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            IconButton(onClick = { onDelete(bookmark) }) {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NotesPanel(
    notes: List<Note>,
    onNoteClick: (Note) -> Unit,
    onDelete: (Note) -> Unit,
    onAddNote: () -> Unit,
    onDismiss: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(0.4f)
            .fillMaxHeight(),
        shadowElevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Notes", style = MaterialTheme.typography.titleMedium)
                Row {
                    IconButton(onClick = onAddNote) {
                        Icon(Icons.Default.Add, contentDescription = "Add Note")
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            if (notes.isEmpty()) {
                Text(
                    "No notes yet",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            } else {
                LazyColumn {
                    items(notes, key = { it.id }) { note ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                                .clickable { onNoteClick(note) }
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text(
                                    note.content,
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    IconButton(onClick = { onDelete(note) }) {
                                        Icon(
                                            Icons.Default.Delete,
                                            contentDescription = "Delete",
                                            tint = MaterialTheme.colorScheme.error
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TextSelectionBar(
    text: String,
    translatedText: String?,
    onCopy: () -> Unit,
    onTranslate: () -> Unit,
    onClear: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        shadowElevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = text,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium
            )
            if (translatedText != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = translatedText,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = onCopy, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.ContentCopy, contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Copy")
                }
                Button(onClick = onTranslate, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Translate, contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Translate")
                }
                IconButton(onClick = onClear) {
                    Icon(Icons.Default.Close, contentDescription = "Clear")
                }
            }
        }
    }
}

@Composable
fun LanguageSelector(
    selectedLang: String,
    onLangChange: (String) -> Unit
) {
    val languages = mapOf(
        "en" to "English",
        "es" to "Spanish",
        "fr" to "French",
        "de" to "German",
        "zh" to "Chinese",
        "ja" to "Japanese"
    )

    Column {
        languages.forEach { (code, name) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onLangChange(code) }
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedLang == code,
                    onClick = { onLangChange(code) }
                )
                Text(name)
            }
        }
    }
}
