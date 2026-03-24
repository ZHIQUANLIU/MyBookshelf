package com.mybookshelf.ui.screens.reader;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.style.TextOverflow;
import com.mybookshelf.domain.model.Bookmark;
import com.mybookshelf.domain.model.Note;
import com.mybookshelf.util.BookContent;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aL\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001aT\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a$\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001aZ\u0010\u0016\u001a\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a,\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001aN\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u000e2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a(\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010&\u001a\u00020\'H\u0007\u001aT\u0010(\u001a\u00020\u00012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u001c\u001a\u00020\u000e2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001aD\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\u00112\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u00a8\u00060"}, d2 = {"BookmarksPanel", "", "bookmarks", "", "Lcom/mybookshelf/domain/model/Bookmark;", "onBookmarkClick", "Lkotlin/Function1;", "onDelete", "onDismiss", "Lkotlin/Function0;", "EpubReaderContent", "chapters", "Lcom/mybookshelf/util/Chapter;", "currentChapter", "", "onChapterChange", "onTextSelected", "", "onToggleToolbar", "LanguageSelector", "selectedLang", "onLangChange", "NotesPanel", "notes", "Lcom/mybookshelf/domain/model/Note;", "onNoteClick", "onAddNote", "PageNavigation", "currentPage", "totalPages", "onPageChange", "PdfReaderContent", "content", "Lcom/mybookshelf/util/BookContent$PdfPages;", "ReaderScreen", "bookId", "", "onBack", "viewModel", "Lcom/mybookshelf/ui/screens/reader/ReaderViewModel;", "TextReaderContent", "pages", "TextSelectionBar", "text", "translatedText", "onCopy", "onTranslate", "onClear", "app_debug"})
public final class ReaderScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ReaderScreen(long bookId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    com.mybookshelf.ui.screens.reader.ReaderViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TextReaderContent(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> pages, int currentPage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onPageChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTextSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onToggleToolbar) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PdfReaderContent(@org.jetbrains.annotations.NotNull()
    com.mybookshelf.util.BookContent.PdfPages content, int currentPage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onPageChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTextSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onToggleToolbar) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EpubReaderContent(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mybookshelf.util.Chapter> chapters, int currentChapter, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onChapterChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTextSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onToggleToolbar) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PageNavigation(int currentPage, int totalPages, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onPageChange) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BookmarksPanel(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mybookshelf.domain.model.Bookmark> bookmarks, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.mybookshelf.domain.model.Bookmark, kotlin.Unit> onBookmarkClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.mybookshelf.domain.model.Bookmark, kotlin.Unit> onDelete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NotesPanel(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mybookshelf.domain.model.Note> notes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.mybookshelf.domain.model.Note, kotlin.Unit> onNoteClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.mybookshelf.domain.model.Note, kotlin.Unit> onDelete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddNote, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TextSelectionBar(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.Nullable()
    java.lang.String translatedText, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onCopy, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onTranslate, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClear) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LanguageSelector(@org.jetbrains.annotations.NotNull()
    java.lang.String selectedLang, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onLangChange) {
    }
}