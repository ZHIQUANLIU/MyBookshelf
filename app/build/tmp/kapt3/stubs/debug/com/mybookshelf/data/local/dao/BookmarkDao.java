package com.mybookshelf.data.local.dao;

import androidx.room.*;
import com.mybookshelf.data.local.entity.BookmarkEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/mybookshelf/data/local/dao/BookmarkDao;", "", "deleteAllBookmarksByBook", "", "bookId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBookmark", "bookmark", "Lcom/mybookshelf/data/local/entity/BookmarkEntity;", "(Lcom/mybookshelf/data/local/entity/BookmarkEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookmarkById", "id", "getBookmarksByBook", "Lkotlinx/coroutines/flow/Flow;", "", "insertBookmark", "app_debug"})
@androidx.room.Dao()
public abstract interface BookmarkDao {
    
    @androidx.room.Query(value = "SELECT * FROM bookmarks WHERE bookId = :bookId ORDER BY position")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.data.local.entity.BookmarkEntity>> getBookmarksByBook(long bookId);
    
    @androidx.room.Query(value = "SELECT * FROM bookmarks WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBookmarkById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mybookshelf.data.local.entity.BookmarkEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertBookmark(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.entity.BookmarkEntity bookmark, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteBookmark(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.entity.BookmarkEntity bookmark, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM bookmarks WHERE bookId = :bookId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllBookmarksByBook(long bookId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}