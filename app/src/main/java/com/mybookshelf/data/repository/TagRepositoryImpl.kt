package com.mybookshelf.data.repository

import com.mybookshelf.data.local.dao.TagDao
import com.mybookshelf.data.local.entity.TagEntity
import com.mybookshelf.domain.model.Tag
import com.mybookshelf.domain.repository.TagRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagRepositoryImpl @Inject constructor(
    private val tagDao: TagDao
) : TagRepository {

    override fun getAllTags(): Flow<List<Tag>> {
        return tagDao.getAllTags().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun searchTags(query: String): Flow<List<Tag>> {
        return tagDao.searchTags(query).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertTag(tag: Tag): Long {
        return tagDao.insertTag(tag.toEntity())
    }

    override suspend fun deleteTag(tag: Tag) {
        tagDao.deleteTag(tag.toEntity())
    }

    private fun TagEntity.toDomain(): Tag {
        return Tag(id = id, name = name)
    }

    private fun Tag.toEntity(): TagEntity {
        return TagEntity(id = id, name = name)
    }
}
