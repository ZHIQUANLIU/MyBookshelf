package com.mybookshelf.data.repository

import com.mybookshelf.data.local.dao.CategoryDao
import com.mybookshelf.data.local.entity.CategoryEntity
import com.mybookshelf.domain.model.Category
import com.mybookshelf.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryRepository {

    override fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAllCategories().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getCategoryById(id: Long): Category? {
        return categoryDao.getCategoryById(id)?.toDomain()
    }

    override suspend fun insertCategory(category: Category): Long {
        return categoryDao.insertCategory(category.toEntity())
    }

    override suspend fun updateCategory(category: Category) {
        categoryDao.updateCategory(category.toEntity())
    }

    override suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category.toEntity())
    }

    private fun CategoryEntity.toDomain(): Category {
        return Category(id = id, name = name, color = color)
    }

    private fun Category.toEntity(): CategoryEntity {
        return CategoryEntity(id = id, name = name, color = color)
    }
}
