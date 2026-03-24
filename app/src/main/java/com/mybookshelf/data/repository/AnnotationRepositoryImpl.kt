package com.mybookshelf.data.repository

import com.mybookshelf.data.local.dao.BookmarkDao
import com.mybookshelf.data.local.dao.NoteDao
import com.mybookshelf.data.local.entity.BookmarkEntity
import com.mybookshelf.data.local.entity.NoteEntity
import com.mybookshelf.domain.model.Bookmark
import com.mybookshelf.domain.model.Note
import com.mybookshelf.domain.repository.BookmarkRepository
import com.mybookshelf.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookmarkRepositoryImpl @Inject constructor(
    private val bookmarkDao: BookmarkDao
) : BookmarkRepository {

    override fun getBookmarksByBook(bookId: Long): Flow<List<Bookmark>> {
        return bookmarkDao.getBookmarksByBook(bookId).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getBookmarkById(id: Long): Bookmark? {
        return bookmarkDao.getBookmarkById(id)?.toDomain()
    }

    override suspend fun insertBookmark(bookmark: Bookmark): Long {
        return bookmarkDao.insertBookmark(bookmark.toEntity())
    }

    override suspend fun deleteBookmark(bookmark: Bookmark) {
        bookmarkDao.deleteBookmark(bookmark.toEntity())
    }

    override suspend fun deleteAllBookmarksByBook(bookId: Long) {
        bookmarkDao.deleteAllBookmarksByBook(bookId)
    }

    private fun BookmarkEntity.toDomain(): Bookmark {
        return Bookmark(
            id = id,
            bookId = bookId,
            position = position,
            title = title,
            dateCreated = dateCreated
        )
    }

    private fun Bookmark.toEntity(): BookmarkEntity {
        return BookmarkEntity(
            id = id,
            bookId = bookId,
            position = position,
            title = title,
            dateCreated = dateCreated
        )
    }
}

@Singleton
class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getNotesByBook(bookId: Long): Flow<List<Note>> {
        return noteDao.getNotesByBook(bookId).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getNoteById(id: Long): Note? {
        return noteDao.getNoteById(id)?.toDomain()
    }

    override suspend fun insertNote(note: Note): Long {
        return noteDao.insertNote(note.toEntity())
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note.toEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toEntity())
    }

    override suspend fun deleteAllNotesByBook(bookId: Long) {
        noteDao.deleteAllNotesByBook(bookId)
    }

    private fun NoteEntity.toDomain(): Note {
        return Note(
            id = id,
            bookId = bookId,
            position = position,
            content = content,
            dateCreated = dateCreated,
            dateModified = dateModified
        )
    }

    private fun Note.toEntity(): NoteEntity {
        return NoteEntity(
            id = id,
            bookId = bookId,
            position = position,
            content = content,
            dateCreated = dateCreated,
            dateModified = dateModified
        )
    }
}
