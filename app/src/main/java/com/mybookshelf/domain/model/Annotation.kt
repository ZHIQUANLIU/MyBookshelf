package com.mybookshelf.domain.model

data class Bookmark(
    val id: Long = 0,
    val bookId: Long,
    val position: Int,
    val title: String,
    val dateCreated: Long = System.currentTimeMillis()
)

data class Note(
    val id: Long = 0,
    val bookId: Long,
    val position: Int,
    val content: String,
    val dateCreated: Long = System.currentTimeMillis(),
    val dateModified: Long = System.currentTimeMillis()
)
