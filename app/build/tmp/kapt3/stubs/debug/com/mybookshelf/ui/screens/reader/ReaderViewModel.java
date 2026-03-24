package com.mybookshelf.ui.screens.reader;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import com.mybookshelf.domain.model.Book;
import com.mybookshelf.domain.model.Bookmark;
import com.mybookshelf.domain.model.Note;
import com.mybookshelf.domain.repository.BookRepository;
import com.mybookshelf.domain.repository.BookmarkRepository;
import com.mybookshelf.domain.repository.NoteRepository;
import com.mybookshelf.util.BookContent;
import com.mybookshelf.util.BookParser;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0011J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0019J\u0006\u0010&\u001a\u00020\u0017J\u0016\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!J\u000e\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006."}, d2 = {"Lcom/mybookshelf/ui/screens/reader/ReaderViewModel;", "Landroidx/lifecycle/ViewModel;", "application", "Landroid/app/Application;", "bookRepository", "Lcom/mybookshelf/domain/repository/BookRepository;", "bookmarkRepository", "Lcom/mybookshelf/domain/repository/BookmarkRepository;", "noteRepository", "Lcom/mybookshelf/domain/repository/NoteRepository;", "(Landroid/app/Application;Lcom/mybookshelf/domain/repository/BookRepository;Lcom/mybookshelf/domain/repository/BookmarkRepository;Lcom/mybookshelf/domain/repository/NoteRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mybookshelf/ui/screens/reader/ReaderUiState;", "bookParser", "Lcom/mybookshelf/util/BookParser;", "currentBookId", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addBookmark", "", "title", "", "addNote", "content", "deleteBookmark", "bookmark", "Lcom/mybookshelf/domain/model/Bookmark;", "deleteNote", "note", "Lcom/mybookshelf/domain/model/Note;", "loadBook", "bookId", "setSelectedText", "text", "toggleToolbar", "translateText", "apiKey", "targetLang", "updateNote", "updatePage", "page", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ReaderViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application application = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mybookshelf.domain.repository.BookRepository bookRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mybookshelf.domain.repository.BookmarkRepository bookmarkRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mybookshelf.domain.repository.NoteRepository noteRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.mybookshelf.ui.screens.reader.ReaderUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.mybookshelf.ui.screens.reader.ReaderUiState> uiState = null;
    private long currentBookId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.mybookshelf.util.BookParser bookParser = null;
    
    @javax.inject.Inject()
    public ReaderViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.repository.BookRepository bookRepository, @org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.repository.BookmarkRepository bookmarkRepository, @org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.repository.NoteRepository noteRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.mybookshelf.ui.screens.reader.ReaderUiState> getUiState() {
        return null;
    }
    
    public final void loadBook(long bookId) {
    }
    
    public final void updatePage(int page) {
    }
    
    public final void toggleToolbar() {
    }
    
    public final void addBookmark(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    public final void deleteBookmark(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Bookmark bookmark) {
    }
    
    public final void addNote(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void updateNote(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Note note) {
    }
    
    public final void deleteNote(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.domain.model.Note note) {
    }
    
    public final void setSelectedText(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void translateText(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    java.lang.String targetLang) {
    }
}