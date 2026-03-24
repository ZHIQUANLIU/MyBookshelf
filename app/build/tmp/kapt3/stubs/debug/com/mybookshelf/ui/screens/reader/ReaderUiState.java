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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0015J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\fH\u00c6\u0003J\t\u0010-\u001a\u00020\fH\u00c6\u0003J\t\u0010.\u001a\u00020\u000fH\u00c6\u0003J\t\u0010/\u001a\u00020\u000fH\u00c6\u0003J\t\u00100\u001a\u00020\u0012H\u00c6\u0003J\u008b\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u00c6\u0001J\u0013\u00102\u001a\u00020\u000f2\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u00020\fH\u00d6\u0001J\t\u00105\u001a\u00020\u0012H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010 R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001f\u00a8\u00066"}, d2 = {"Lcom/mybookshelf/ui/screens/reader/ReaderUiState;", "", "book", "Lcom/mybookshelf/domain/model/Book;", "bookContent", "Lcom/mybookshelf/util/BookContent;", "bookmarks", "", "Lcom/mybookshelf/domain/model/Bookmark;", "notes", "Lcom/mybookshelf/domain/model/Note;", "currentPage", "", "totalPages", "isLoading", "", "showToolbar", "selectedText", "", "translatedText", "error", "(Lcom/mybookshelf/domain/model/Book;Lcom/mybookshelf/util/BookContent;Ljava/util/List;Ljava/util/List;IIZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBook", "()Lcom/mybookshelf/domain/model/Book;", "getBookContent", "()Lcom/mybookshelf/util/BookContent;", "getBookmarks", "()Ljava/util/List;", "getCurrentPage", "()I", "getError", "()Ljava/lang/String;", "()Z", "getNotes", "getSelectedText", "getShowToolbar", "getTotalPages", "getTranslatedText", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class ReaderUiState {
    @org.jetbrains.annotations.Nullable()
    private final com.mybookshelf.domain.model.Book book = null;
    @org.jetbrains.annotations.Nullable()
    private final com.mybookshelf.util.BookContent bookContent = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.mybookshelf.domain.model.Bookmark> bookmarks = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.mybookshelf.domain.model.Note> notes = null;
    private final int currentPage = 0;
    private final int totalPages = 0;
    private final boolean isLoading = false;
    private final boolean showToolbar = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String selectedText = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String translatedText = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    
    public ReaderUiState(@org.jetbrains.annotations.Nullable()
    com.mybookshelf.domain.model.Book book, @org.jetbrains.annotations.Nullable()
    com.mybookshelf.util.BookContent bookContent, @org.jetbrains.annotations.NotNull()
    java.util.List<com.mybookshelf.domain.model.Bookmark> bookmarks, @org.jetbrains.annotations.NotNull()
    java.util.List<com.mybookshelf.domain.model.Note> notes, int currentPage, int totalPages, boolean isLoading, boolean showToolbar, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedText, @org.jetbrains.annotations.Nullable()
    java.lang.String translatedText, @org.jetbrains.annotations.Nullable()
    java.lang.String error) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mybookshelf.domain.model.Book getBook() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mybookshelf.util.BookContent getBookContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mybookshelf.domain.model.Bookmark> getBookmarks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mybookshelf.domain.model.Note> getNotes() {
        return null;
    }
    
    public final int getCurrentPage() {
        return 0;
    }
    
    public final int getTotalPages() {
        return 0;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final boolean getShowToolbar() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTranslatedText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    public ReaderUiState() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mybookshelf.domain.model.Book component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mybookshelf.util.BookContent component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mybookshelf.domain.model.Bookmark> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mybookshelf.domain.model.Note> component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mybookshelf.ui.screens.reader.ReaderUiState copy(@org.jetbrains.annotations.Nullable()
    com.mybookshelf.domain.model.Book book, @org.jetbrains.annotations.Nullable()
    com.mybookshelf.util.BookContent bookContent, @org.jetbrains.annotations.NotNull()
    java.util.List<com.mybookshelf.domain.model.Bookmark> bookmarks, @org.jetbrains.annotations.NotNull()
    java.util.List<com.mybookshelf.domain.model.Note> notes, int currentPage, int totalPages, boolean isLoading, boolean showToolbar, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedText, @org.jetbrains.annotations.Nullable()
    java.lang.String translatedText, @org.jetbrains.annotations.Nullable()
    java.lang.String error) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}