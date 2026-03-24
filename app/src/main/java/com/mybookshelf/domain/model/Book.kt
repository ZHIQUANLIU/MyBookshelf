package com.mybookshelf.domain.model

data class Book(
    val id: Long = 0,
    val title: String,
    val author: String,
    val filePath: String,
    val coverPath: String? = null,
    val format: String,
    val dateAdded: Long = System.currentTimeMillis(),
    val lastRead: Long? = null,
    val readingPosition: Int = 0,
    val categories: List<Category> = emptyList(),
    val tags: List<Tag> = emptyList()
)
