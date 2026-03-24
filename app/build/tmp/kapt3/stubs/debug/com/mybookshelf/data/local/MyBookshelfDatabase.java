package com.mybookshelf.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.mybookshelf.data.local.dao.*;
import com.mybookshelf.data.local.entity.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/mybookshelf/data/local/MyBookshelfDatabase;", "Landroidx/room/RoomDatabase;", "()V", "bookDao", "Lcom/mybookshelf/data/local/dao/BookDao;", "bookmarkDao", "Lcom/mybookshelf/data/local/dao/BookmarkDao;", "categoryDao", "Lcom/mybookshelf/data/local/dao/CategoryDao;", "noteDao", "Lcom/mybookshelf/data/local/dao/NoteDao;", "tagDao", "Lcom/mybookshelf/data/local/dao/TagDao;", "app_debug"})
@androidx.room.Database(entities = {com.mybookshelf.data.local.entity.BookEntity.class, com.mybookshelf.data.local.entity.CategoryEntity.class, com.mybookshelf.data.local.entity.TagEntity.class, com.mybookshelf.data.local.entity.BookCategoryEntity.class, com.mybookshelf.data.local.entity.BookTagEntity.class, com.mybookshelf.data.local.entity.BookmarkEntity.class, com.mybookshelf.data.local.entity.NoteEntity.class}, version = 1, exportSchema = false)
public abstract class MyBookshelfDatabase extends androidx.room.RoomDatabase {
    
    public MyBookshelfDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.mybookshelf.data.local.dao.BookDao bookDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.mybookshelf.data.local.dao.CategoryDao categoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.mybookshelf.data.local.dao.TagDao tagDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.mybookshelf.data.local.dao.BookmarkDao bookmarkDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.mybookshelf.data.local.dao.NoteDao noteDao();
}