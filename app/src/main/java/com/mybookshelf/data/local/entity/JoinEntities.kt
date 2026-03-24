package com.mybookshelf.data.local.entity

import androidx.room.Entity

@Entity(tableName = "book_categories", primaryKeys = ["bookId", "categoryId"])
data class BookCategoryEntity(
    val bookId: Long,
    val categoryId: Long
)

@Entity(tableName = "book_tags", primaryKeys = ["bookId", "tagId"])
data class BookTagEntity(
    val bookId: Long,
    val tagId: Long
)
