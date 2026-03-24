package com.mybookshelf.domain.model

data class Category(
    val id: Long = 0,
    val name: String,
    val color: String = "#1565C0"
)

data class Tag(
    val id: Long = 0,
    val name: String
)
