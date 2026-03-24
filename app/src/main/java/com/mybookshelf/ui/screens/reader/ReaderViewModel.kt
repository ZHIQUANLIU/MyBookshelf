package com.mybookshelf.ui.screens.reader

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mybookshelf.domain.model.Book
import com.mybookshelf.domain.model.Bookmark
import com.mybookshelf.domain.model.Note
import com.mybookshelf.domain.repository.BookRepository
import com.mybookshelf.domain.repository.BookmarkRepository
import com.mybookshelf.domain.repository.NoteRepository
import com.mybookshelf.util.BookContent
import com.mybookshelf.util.BookParser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ReaderUiState(
    val book: Book? = null,
    val bookContent: BookContent? = null,
    val bookmarks: List<Bookmark> = emptyList(),
    val notes: List<Note> = emptyList(),
    val currentPage: Int = 0,
    val totalPages: Int = 0,
    val isLoading: Boolean = true,
    val showToolbar: Boolean = true,
    val selectedText: String = "",
    val translatedText: String? = null,
    val error: String? = null
)

@HiltViewModel
class ReaderViewModel @Inject constructor(
    private val application: Application,
    private val bookRepository: BookRepository,
    private val bookmarkRepository: BookmarkRepository,
    private val noteRepository: NoteRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ReaderUiState())
    val uiState: StateFlow<ReaderUiState> = _uiState.asStateFlow()

    private var currentBookId: Long = 0
    private val bookParser = BookParser(application)

    fun loadBook(bookId: Long) {
        currentBookId = bookId
        viewModelScope.launch {
            val book = bookRepository.getBookById(bookId)
            
            book?.let { b ->
                val result = bookParser.parseBook(b.filePath, b.format)
                result.fold(
                    onSuccess = { content ->
                        val total = when (content) {
                            is BookContent.TextContent -> content.pages.size
                            is BookContent.PdfPages -> content.totalPages
                            is BookContent.EpubContent -> content.chapters.size
                        }
                        _uiState.update { 
                            it.copy(
                                book = book, 
                                bookContent = content,
                                totalPages = total,
                                currentPage = b.readingPosition ?: 0,
                                isLoading = false
                            ) 
                        }
                    },
                    onFailure = { e ->
                        _uiState.update { 
                            it.copy(
                                book = book, 
                                isLoading = false,
                                error = e.message
                            ) 
                        }
                    }
                )
            } ?: run {
                _uiState.update { it.copy(isLoading = false, error = "Book not found") }
            }

            bookmarkRepository.getBookmarksByBook(bookId).collect { bookmarks ->
                _uiState.update { it.copy(bookmarks = bookmarks) }
            }
        }
        viewModelScope.launch {
            noteRepository.getNotesByBook(bookId).collect { notes ->
                _uiState.update { it.copy(notes = notes) }
            }
        }
    }

    fun updatePage(page: Int) {
        _uiState.update { it.copy(currentPage = page) }
        viewModelScope.launch {
            bookRepository.updateReadingPosition(currentBookId, page)
        }
    }

    fun toggleToolbar() {
        _uiState.update { it.copy(showToolbar = !it.showToolbar) }
    }

    fun addBookmark(title: String) {
        viewModelScope.launch {
            val bookmark = Bookmark(
                bookId = currentBookId,
                position = _uiState.value.currentPage,
                title = title
            )
            bookmarkRepository.insertBookmark(bookmark)
        }
    }

    fun deleteBookmark(bookmark: Bookmark) {
        viewModelScope.launch {
            bookmarkRepository.deleteBookmark(bookmark)
        }
    }

    fun addNote(content: String) {
        viewModelScope.launch {
            val note = Note(
                bookId = currentBookId,
                position = _uiState.value.currentPage,
                content = content
            )
            noteRepository.insertNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteRepository.updateNote(note.copy(dateModified = System.currentTimeMillis()))
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }

    fun setSelectedText(text: String) {
        _uiState.update { it.copy(selectedText = text, translatedText = null) }
    }

    fun translateText(apiKey: String, targetLang: String) {
        // Translation would be implemented with API call
        // Placeholder for now
        _uiState.update { it.copy(translatedText = "Translation feature") }
    }
}
