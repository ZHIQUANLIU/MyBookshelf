package com.mybookshelf.di

import android.content.Context
import androidx.room.Room
import com.mybookshelf.data.local.MyBookshelfDatabase
import com.mybookshelf.data.local.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MyBookshelfDatabase {
        return Room.databaseBuilder(
            context,
            MyBookshelfDatabase::class.java,
            "mybookshelf.db"
        ).build()
    }

    @Provides
    fun provideBookDao(database: MyBookshelfDatabase): BookDao = database.bookDao()

    @Provides
    fun provideCategoryDao(database: MyBookshelfDatabase): CategoryDao = database.categoryDao()

    @Provides
    fun provideTagDao(database: MyBookshelfDatabase): TagDao = database.tagDao()

    @Provides
    fun provideBookmarkDao(database: MyBookshelfDatabase): BookmarkDao = database.bookmarkDao()

    @Provides
    fun provideNoteDao(database: MyBookshelfDatabase): NoteDao = database.noteDao()
}
