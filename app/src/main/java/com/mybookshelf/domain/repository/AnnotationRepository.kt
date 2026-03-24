package com.mybookshelf.domain.repository

import com.mybookshelf.domain.model.Bookmark
import com.mybookshelf.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {
    fun getBookmarksByBook(bookId: Long): Flow<List<Bookmark>>
    suspend fun getBookmarkById(id: Long): Bookmark?
    suspend fun insertBookmark(bookmark: Bookmark): Long
    suspend fun deleteBookmark(bookmark: Bookmark)
    suspend fun deleteAllBookmarksByBook(bookId: Long)
}

interface NoteRepository {
    fun getNotesByBook(bookId: Long): Flow<List<Note>>
    suspend fun getNoteById(id: Long): Note?
    suspend fun insertNote(note: Note): Long
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun deleteAllNotesByBook(bookId: Long)
}
