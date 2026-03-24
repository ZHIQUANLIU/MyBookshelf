package com.mybookshelf.data.local.dao;

import androidx.room.*;
import com.mybookshelf.data.local.entity.BookEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J(\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/mybookshelf/data/local/dao/BookDao;", "", "deleteBook", "", "book", "Lcom/mybookshelf/data/local/entity/BookEntity;", "(Lcom/mybookshelf/data/local/entity/BookEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllBooks", "Lkotlinx/coroutines/flow/Flow;", "", "getBookById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertBook", "searchBooks", "query", "", "updateBook", "updateReadingPosition", "bookId", "position", "", "timestamp", "(JIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface BookDao {
    
    @androidx.room.Query(value = "SELECT * FROM books ORDER BY dateAdded DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.data.local.entity.BookEntity>> getAllBooks();
    
    @androidx.room.Query(value = "SELECT * FROM books WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBookById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mybookshelf.data.local.entity.BookEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM books WHERE title LIKE \'%\' || :query || \'%\' OR author LIKE \'%\' || :query || \'%\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.data.local.entity.BookEntity>> searchBooks(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertBook(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.entity.BookEntity book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateBook(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.entity.BookEntity book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteBook(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.entity.BookEntity book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE books SET readingPosition = :position, lastRead = :timestamp WHERE id = :bookId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateReadingPosition(long bookId, int position, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}