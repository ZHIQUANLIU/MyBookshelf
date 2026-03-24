package com.mybookshelf.di;

import android.content.Context;
import androidx.room.Room;
import com.mybookshelf.data.local.MyBookshelfDatabase;
import com.mybookshelf.data.local.dao.*;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/mybookshelf/di/DatabaseModule;", "", "()V", "provideBookDao", "Lcom/mybookshelf/data/local/dao/BookDao;", "database", "Lcom/mybookshelf/data/local/MyBookshelfDatabase;", "provideBookmarkDao", "Lcom/mybookshelf/data/local/dao/BookmarkDao;", "provideCategoryDao", "Lcom/mybookshelf/data/local/dao/CategoryDao;", "provideDatabase", "context", "Landroid/content/Context;", "provideNoteDao", "Lcom/mybookshelf/data/local/dao/NoteDao;", "provideTagDao", "Lcom/mybookshelf/data/local/dao/TagDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.mybookshelf.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.mybookshelf.data.local.MyBookshelfDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.mybookshelf.data.local.dao.BookDao provideBookDao(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.MyBookshelfDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.mybookshelf.data.local.dao.CategoryDao provideCategoryDao(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.MyBookshelfDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.mybookshelf.data.local.dao.TagDao provideTagDao(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.MyBookshelfDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.mybookshelf.data.local.dao.BookmarkDao provideBookmarkDao(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.MyBookshelfDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.mybookshelf.data.local.dao.NoteDao provideNoteDao(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.MyBookshelfDatabase database) {
        return null;
    }
}