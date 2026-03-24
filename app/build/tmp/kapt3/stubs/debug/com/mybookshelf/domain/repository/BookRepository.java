package com.mybookshelf.domain.repository;

import com.mybookshelf.domain.model.Book;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000fH&J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u00a6@\u00a2\u0006\u0002\u0010 \u00a8\u0006!"}, d2 = {"Lcom/mybookshelf/domain/repository/BookRepository;", "", "addCategoryToBook", "", "bookId", "", "categoryId", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTagToBook", "tagId", "deleteBook", "book", "Lcom/mybookshelf/domain/model/Book;", "(Lcom/mybookshelf/domain/model/Book;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllBooks", "Lkotlinx/coroutines/flow/Flow;", "", "getBookById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookIdsByCategory", "getTagIdsByBook", "insertBook", "removeCategoryFromBook", "removeTagFromBook", "searchBooks", "query", "", "updateBook", "updateReadingPosition", "position", "", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface BookRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.domain.model.Book>> getAllBooks();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.domain.model.Book>> searchBooks(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBookById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mybookshelf.domain.model.Book> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertBook(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Book book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateBook(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Book book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteBook(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Book book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateReadingPosition(long bookId, int position, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addCategoryToBook(long bookId, long categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeCategoryFromBook(long bookId, long categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addTagToBook(long bookId, long tagId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeTagFromBook(long bookId, long tagId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<java.lang.Long>> getBookIdsByCategory(long categoryId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<java.lang.Long>> getTagIdsByBook(long bookId);
}