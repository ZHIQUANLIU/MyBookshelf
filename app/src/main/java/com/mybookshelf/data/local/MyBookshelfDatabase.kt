package com.mybookshelf.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mybookshelf.data.local.dao.*
import com.mybookshelf.data.local.entity.*

@Database(
    entities = [
        BookEntity::class,
        CategoryEntity::class,
        TagEntity::class,
        BookCategoryEntity::class,
        BookTagEntity::class,
        BookmarkEntity::class,
        NoteEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MyBookshelfDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun categoryDao(): CategoryDao
    abstract fun tagDao(): TagDao
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun noteDao(): NoteDao
}
