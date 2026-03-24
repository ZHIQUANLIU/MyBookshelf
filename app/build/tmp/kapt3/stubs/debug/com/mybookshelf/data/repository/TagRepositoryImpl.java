package com.mybookshelf.data.repository;

import com.mybookshelf.data.local.dao.TagDao;
import com.mybookshelf.data.local.entity.TagEntity;
import com.mybookshelf.domain.model.Tag;
import com.mybookshelf.domain.repository.TagRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bH\u0016J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\f\u0010\u0012\u001a\u00020\b*\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u0013*\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/mybookshelf/data/repository/TagRepositoryImpl;", "Lcom/mybookshelf/domain/repository/TagRepository;", "tagDao", "Lcom/mybookshelf/data/local/dao/TagDao;", "(Lcom/mybookshelf/data/local/dao/TagDao;)V", "deleteTag", "", "tag", "Lcom/mybookshelf/domain/model/Tag;", "(Lcom/mybookshelf/domain/model/Tag;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTags", "Lkotlinx/coroutines/flow/Flow;", "", "insertTag", "", "searchTags", "query", "", "toDomain", "Lcom/mybookshelf/data/local/entity/TagEntity;", "toEntity", "app_debug"})
public final class TagRepositoryImpl implements com.mybookshelf.domain.repository.TagRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.mybookshelf.data.local.dao.TagDao tagDao = null;
    
    @javax.inject.Inject()
    public TagRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.dao.TagDao tagDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.domain.model.Tag>> getAllTags() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.domain.model.Tag>> searchTags(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertTag(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Tag tag, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteTag(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Tag tag, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.mybookshelf.domain.model.Tag toDomain(com.mybookshelf.data.local.entity.TagEntity $this$toDomain) {
        return null;
    }
    
    private final com.mybookshelf.data.local.entity.TagEntity toEntity(com.mybookshelf.domain.model.Tag $this$toEntity) {
        return null;
    }
}