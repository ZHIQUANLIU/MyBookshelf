package com.mybookshelf.data.repository;

import com.mybookshelf.data.local.dao.CategoryDao;
import com.mybookshelf.data.local.entity.CategoryEntity;
import com.mybookshelf.domain.model.Category;
import com.mybookshelf.domain.repository.CategoryRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bH\u0016J\u0018\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\f\u0010\u0013\u001a\u00020\b*\u00020\u0014H\u0002J\f\u0010\u0015\u001a\u00020\u0014*\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/mybookshelf/data/repository/CategoryRepositoryImpl;", "Lcom/mybookshelf/domain/repository/CategoryRepository;", "categoryDao", "Lcom/mybookshelf/data/local/dao/CategoryDao;", "(Lcom/mybookshelf/data/local/dao/CategoryDao;)V", "deleteCategory", "", "category", "Lcom/mybookshelf/domain/model/Category;", "(Lcom/mybookshelf/domain/model/Category;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCategories", "Lkotlinx/coroutines/flow/Flow;", "", "getCategoryById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCategory", "updateCategory", "toDomain", "Lcom/mybookshelf/data/local/entity/CategoryEntity;", "toEntity", "app_debug"})
public final class CategoryRepositoryImpl implements com.mybookshelf.domain.repository.CategoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.mybookshelf.data.local.dao.CategoryDao categoryDao = null;
    
    @javax.inject.Inject()
    public CategoryRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.dao.CategoryDao categoryDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.domain.model.Category>> getAllCategories() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCategoryById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mybookshelf.domain.model.Category> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertCategory(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Category category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateCategory(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Category category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteCategory(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Category category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.mybookshelf.domain.model.Category toDomain(com.mybookshelf.data.local.entity.CategoryEntity $this$toDomain) {
        return null;
    }
    
    private final com.mybookshelf.data.local.entity.CategoryEntity toEntity(com.mybookshelf.domain.model.Category $this$toEntity) {
        return null;
    }
}