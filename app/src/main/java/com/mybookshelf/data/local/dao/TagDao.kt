package com.mybookshelf.data.local.dao

import androidx.room.*
import com.mybookshelf.data.local.entity.TagEntity
import com.mybookshelf.data.local.entity.BookTagEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TagDao {
    @Query("SELECT * FROM tags ORDER BY name")
    fun getAllTags(): Flow<List<TagEntity>>

    @Query("SELECT * FROM tags WHERE name LIKE '%' || :query || '%'")
    fun searchTags(query: String): Flow<List<TagEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTag(tag: TagEntity): Long

    @Delete
    suspend fun deleteTag(tag: TagEntity)

    @Query("SELECT tagId FROM book_tags WHERE bookId = :bookId")
    fun getTagIdsByBook(bookId: Long): Flow<List<Long>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookTag(bookTag: BookTagEntity)

    @Delete
    suspend fun deleteBookTag(bookTag: BookTagEntity)

    @Query("DELETE FROM book_tags WHERE bookId = :bookId")
    suspend fun deleteAllBookTags(bookId: Long)
}
