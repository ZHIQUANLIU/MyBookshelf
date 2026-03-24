package com.mybookshelf.data.repository;

import com.mybookshelf.data.local.dao.BookDao;
import com.mybookshelf.data.local.dao.CategoryDao;
import com.mybookshelf.data.local.dao.TagDao;
import com.mybookshelf.data.local.entity.BookCategoryEntity;
import com.mybookshelf.data.local.entity.BookEntity;
import com.mybookshelf.data.local.entity.BookTagEntity;
import com.mybookshelf.domain.model.Book;
import com.mybookshelf.domain.model.Category;
import com.mybookshelf.domain.model.Tag;
import com.mybookshelf.domain.repository.BookRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u0016H\u0016J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00170\u00162\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00170\u00162\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u001e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0016\u0010#\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u001e\u0010$\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H\u0096@\u00a2\u0006\u0002\u0010\'J\f\u0010(\u001a\u00020\u0013*\u00020)H\u0002J\f\u0010*\u001a\u00020)*\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/mybookshelf/data/repository/BookRepositoryImpl;", "Lcom/mybookshelf/domain/repository/BookRepository;", "bookDao", "Lcom/mybookshelf/data/local/dao/BookDao;", "categoryDao", "Lcom/mybookshelf/data/local/dao/CategoryDao;", "tagDao", "Lcom/mybookshelf/data/local/dao/TagDao;", "(Lcom/mybookshelf/data/local/dao/BookDao;Lcom/mybookshelf/data/local/dao/CategoryDao;Lcom/mybookshelf/data/local/dao/TagDao;)V", "addCategoryToBook", "", "bookId", "", "categoryId", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTagToBook", "tagId", "deleteBook", "book", "Lcom/mybookshelf/domain/model/Book;", "(Lcom/mybookshelf/domain/model/Book;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllBooks", "Lkotlinx/coroutines/flow/Flow;", "", "getBookById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookIdsByCategory", "getTagIdsByBook", "insertBook", "removeCategoryFromBook", "removeTagFromBook", "searchBooks", "query", "", "updateBook", "updateReadingPosition", "position", "", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDomain", "Lcom/mybookshelf/data/local/entity/BookEntity;", "toEntity", "app_debug"})
public final class BookRepositoryImpl implements com.mybookshelf.domain.repository.BookRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.mybookshelf.data.local.dao.BookDao bookDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mybookshelf.data.local.dao.CategoryDao categoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mybookshelf.data.local.dao.TagDao tagDao = null;
    
    @javax.inject.Inject()
    public BookRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.dao.BookDao bookDao, @org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.dao.CategoryDao categoryDao, @org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.dao.TagDao tagDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.domain.model.Book>> getAllBooks() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.domain.model.Book>> searchBooks(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getBookById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mybookshelf.domain.model.Book> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertBook(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Book book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateBook(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Book book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteBook(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Book book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateReadingPosition(long bookId, int position, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addCategoryToBook(long bookId, long categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object removeCategoryFromBook(long bookId, long categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addTagToBook(long bookId, long tagId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object removeTagFromBook(long bookId, long tagId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<java.lang.Long>> getBookIdsByCategory(long categoryId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<java.lang.Long>> getTagIdsByBook(long bookId) {
        return null;
    }
    
    private final com.mybookshelf.domain.model.Book toDomain(com.mybookshelf.data.local.entity.BookEntity $this$toDomain) {
        return null;
    }
    
    private final com.mybookshelf.data.local.entity.BookEntity toEntity(com.mybookshelf.domain.model.Book $this$toEntity) {
        return null;
    }
}