package com.mybookshelf.di;

import com.mybookshelf.data.repository.*;
import com.mybookshelf.domain.repository.*;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000fH\'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0012H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/mybookshelf/di/RepositoryModule;", "", "()V", "bindBookRepository", "Lcom/mybookshelf/domain/repository/BookRepository;", "impl", "Lcom/mybookshelf/data/repository/BookRepositoryImpl;", "bindBookmarkRepository", "Lcom/mybookshelf/domain/repository/BookmarkRepository;", "Lcom/mybookshelf/data/repository/BookmarkRepositoryImpl;", "bindCategoryRepository", "Lcom/mybookshelf/domain/repository/CategoryRepository;", "Lcom/mybookshelf/data/repository/CategoryRepositoryImpl;", "bindNoteRepository", "Lcom/mybookshelf/domain/repository/NoteRepository;", "Lcom/mybookshelf/data/repository/NoteRepositoryImpl;", "bindTagRepository", "Lcom/mybookshelf/domain/repository/TagRepository;", "Lcom/mybookshelf/data/repository/TagRepositoryImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.mybookshelf.domain.repository.BookRepository bindBookRepository(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.repository.BookRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.mybookshelf.domain.repository.CategoryRepository bindCategoryRepository(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.repository.CategoryRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.mybookshelf.domain.repository.TagRepository bindTagRepository(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.repository.TagRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.mybookshelf.domain.repository.BookmarkRepository bindBookmarkRepository(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.repository.BookmarkRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.mybookshelf.domain.repository.NoteRepository bindNoteRepository(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.repository.NoteRepositoryImpl impl);
}