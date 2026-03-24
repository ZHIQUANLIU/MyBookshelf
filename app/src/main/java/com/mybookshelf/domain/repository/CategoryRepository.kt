package com.mybookshelf.domain.repository

import com.mybookshelf.domain.model.Category
import com.mybookshelf.domain.model.Tag
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAllCategories(): Flow<List<Category>>
    suspend fun getCategoryById(id: Long): Category?
    suspend fun insertCategory(category: Category): Long
    suspend fun updateCategory(category: Category)
    suspend fun deleteCategory(category: Category)
}

interface TagRepository {
    fun getAllTags(): Flow<List<Tag>>
    fun searchTags(query: String): Flow<List<Tag>>
    suspend fun insertTag(tag: Tag): Long
    suspend fun deleteTag(tag: Tag)
}
