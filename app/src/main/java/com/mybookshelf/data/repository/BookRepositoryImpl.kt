package com.mybookshelf.data.repository

import com.mybookshelf.data.local.dao.BookDao
import com.mybookshelf.data.local.dao.CategoryDao
import com.mybookshelf.data.local.dao.TagDao
import com.mybookshelf.data.local.entity.BookCategoryEntity
import com.mybookshelf.data.local.entity.BookEntity
import com.mybookshelf.data.local.entity.BookTagEntity
import com.mybookshelf.domain.model.Book
import com.mybookshelf.domain.model.Category
import com.mybookshelf.domain.model.Tag
import com.mybookshelf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepositoryImpl @Inject constructor(
    private val bookDao: BookDao,
    private val categoryDao: CategoryDao,
    private val tagDao: TagDao
) : BookRepository {

    override fun getAllBooks(): Flow<List<Book>> {
        return bookDao.getAllBooks().map { entities ->
            entities.map { entity ->
                entity.toDomain()
            }
        }
    }

    override fun searchBooks(query: String): Flow<List<Book>> {
        return bookDao.searchBooks(query).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getBookById(id: Long): Book? {
        return bookDao.getBookById(id)?.toDomain()
    }

    override suspend fun insertBook(book: Book): Long {
        return bookDao.insertBook(book.toEntity())
    }

    override suspend fun updateBook(book: Book) {
        bookDao.updateBook(book.toEntity())
    }

    override suspend fun deleteBook(book: Book) {
        bookDao.deleteBook(book.toEntity())
    }

    override suspend fun updateReadingPosition(bookId: Long, position: Int) {
        bookDao.updateReadingPosition(bookId, position)
    }

    override suspend fun addCategoryToBook(bookId: Long, categoryId: Long) {
        categoryDao.insertBookCategory(BookCategoryEntity(bookId, categoryId))
    }

    override suspend fun removeCategoryFromBook(bookId: Long, categoryId: Long) {
        categoryDao.deleteBookCategory(BookCategoryEntity(bookId, categoryId))
    }

    override suspend fun addTagToBook(bookId: Long, tagId: Long) {
        tagDao.insertBookTag(BookTagEntity(bookId, tagId))
    }

    override suspend fun removeTagFromBook(bookId: Long, tagId: Long) {
        tagDao.deleteBookTag(BookTagEntity(bookId, tagId))
    }

    override fun getBookIdsByCategory(categoryId: Long): Flow<List<Long>> {
        return categoryDao.getBookIdsByCategory(categoryId)
    }

    override fun getTagIdsByBook(bookId: Long): Flow<List<Long>> {
        return tagDao.getTagIdsByBook(bookId)
    }

    private fun BookEntity.toDomain(): Book {
        return Book(
            id = id,
            title = title,
            author = author,
            filePath = filePath,
            coverPath = coverPath,
            format = format,
            dateAdded = dateAdded,
            lastRead = lastRead,
            readingPosition = readingPosition
        )
    }

    private fun Book.toEntity(): BookEntity {
        return BookEntity(
            id = id,
            title = title,
            author = author,
            filePath = filePath,
            coverPath = coverPath,
            format = format,
            dateAdded = dateAdded,
            lastRead = lastRead,
            readingPosition = readingPosition
        )
    }
}
