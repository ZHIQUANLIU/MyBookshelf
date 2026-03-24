package com.mybookshelf.data.local.dao

import androidx.room.*
import com.mybookshelf.data.local.entity.BookCategoryEntity
import com.mybookshelf.data.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories ORDER BY name")
    fun getAllCategories(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM categories WHERE id = :id")
    suspend fun getCategoryById(id: Long): CategoryEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: CategoryEntity): Long

    @Update
    suspend fun updateCategory(category: CategoryEntity)

    @Delete
    suspend fun deleteCategory(category: CategoryEntity)

    @Query("SELECT bookId FROM book_categories WHERE categoryId = :categoryId")
    fun getBookIdsByCategory(categoryId: Long): Flow<List<Long>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookCategory(bookCategory: BookCategoryEntity)

    @Delete
    suspend fun deleteBookCategory(bookCategory: BookCategoryEntity)

    @Query("DELETE FROM book_categories WHERE bookId = :bookId")
    suspend fun deleteAllBookCategories(bookId: Long)
}
