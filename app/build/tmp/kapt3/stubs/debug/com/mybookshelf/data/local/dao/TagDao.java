package com.mybookshelf.data.local.dao;

import androidx.room.*;
import com.mybookshelf.data.local.entity.TagEntity;
import com.mybookshelf.data.local.entity.BookTagEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u0010H\'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\'\u00a8\u0006\u0018"}, d2 = {"Lcom/mybookshelf/data/local/dao/TagDao;", "", "deleteAllBookTags", "", "bookId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBookTag", "bookTag", "Lcom/mybookshelf/data/local/entity/BookTagEntity;", "(Lcom/mybookshelf/data/local/entity/BookTagEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTag", "tag", "Lcom/mybookshelf/data/local/entity/TagEntity;", "(Lcom/mybookshelf/data/local/entity/TagEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTags", "Lkotlinx/coroutines/flow/Flow;", "", "getTagIdsByBook", "insertBookTag", "insertTag", "searchTags", "query", "", "app_debug"})
@androidx.room.Dao()
public abstract interface TagDao {
    
    @androidx.room.Query(value = "SELECT * FROM tags ORDER BY name")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.data.local.entity.TagEntity>> getAllTags();
    
    @androidx.room.Query(value = "SELECT * FROM tags WHERE name LIKE \'%\' || :query || \'%\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.data.local.entity.TagEntity>> searchTags(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTag(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.entity.TagEntity tag, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTag(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.entity.TagEntity tag, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT tagId FROM book_tags WHERE bookId = :bookId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<java.lang.Long>> getTagIdsByBook(long bookId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertBookTag(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.entity.BookTagEntity bookTag, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteBookTag(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.entity.BookTagEntity bookTag, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM book_tags WHERE bookId = :bookId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllBookTags(long bookId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}