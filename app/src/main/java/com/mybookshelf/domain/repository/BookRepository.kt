package com.mybookshelf.domain.repository

import com.mybookshelf.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getAllBooks(): Flow<List<Book>>
    fun searchBooks(query: String): Flow<List<Book>>
    suspend fun getBookById(id: Long): Book?
    suspend fun insertBook(book: Book): Long
    suspend fun updateBook(book: Book)
    suspend fun deleteBook(book: Book)
    suspend fun updateReadingPosition(bookId: Long, position: Int)
    suspend fun addCategoryToBook(bookId: Long, categoryId: Long)
    suspend fun removeCategoryFromBook(bookId: Long, categoryId: Long)
    suspend fun addTagToBook(bookId: Long, tagId: Long)
    suspend fun removeTagFromBook(bookId: Long, tagId: Long)
    fun getBookIdsByCategory(categoryId: Long): Flow<List<Long>>
    fun getTagIdsByBook(bookId: Long): Flow<List<Long>>
}
