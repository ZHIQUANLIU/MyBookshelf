package com.mybookshelf.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val author: String,
    val filePath: String,
    val coverPath: String? = null,
    val format: String,
    val dateAdded: Long = System.currentTimeMillis(),
    val lastRead: Long? = null,
    val readingPosition: Int = 0
)
