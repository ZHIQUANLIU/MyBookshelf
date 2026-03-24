package com.mybookshelf.data.repository;

import com.mybookshelf.data.local.dao.BookmarkDao;
import com.mybookshelf.data.local.dao.NoteDao;
import com.mybookshelf.data.local.entity.BookmarkEntity;
import com.mybookshelf.data.local.entity.NoteEntity;
import com.mybookshelf.domain.model.Bookmark;
import com.mybookshelf.domain.model.Note;
import com.mybookshelf.domain.repository.BookmarkRepository;
import com.mybookshelf.domain.repository.NoteRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00120\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\f\u0010\u0015\u001a\u00020\f*\u00020\u0016H\u0002J\f\u0010\u0017\u001a\u00020\u0016*\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/mybookshelf/data/repository/NoteRepositoryImpl;", "Lcom/mybookshelf/domain/repository/NoteRepository;", "noteDao", "Lcom/mybookshelf/data/local/dao/NoteDao;", "(Lcom/mybookshelf/data/local/dao/NoteDao;)V", "deleteAllNotesByBook", "", "bookId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNote", "note", "Lcom/mybookshelf/domain/model/Note;", "(Lcom/mybookshelf/domain/model/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNoteById", "id", "getNotesByBook", "Lkotlinx/coroutines/flow/Flow;", "", "insertNote", "updateNote", "toDomain", "Lcom/mybookshelf/data/local/entity/NoteEntity;", "toEntity", "app_debug"})
public final class NoteRepositoryImpl implements com.mybookshelf.domain.repository.NoteRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.mybookshelf.data.local.dao.NoteDao noteDao = null;
    
    @javax.inject.Inject()
    public NoteRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.data.local.dao.NoteDao noteDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.mybookshelf.domain.model.Note>> getNotesByBook(long bookId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getNoteById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mybookshelf.domain.model.Note> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertNote(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateNote(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteNote(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteAllNotesByBook(long bookId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.mybookshelf.domain.model.Note toDomain(com.mybookshelf.data.local.entity.NoteEntity $this$toDomain) {
        return null;
    }
    
    private final com.mybookshelf.data.local.entity.NoteEntity toEntity(com.mybookshelf.domain.model.Note $this$toEntity) {
        return null;
    }
}