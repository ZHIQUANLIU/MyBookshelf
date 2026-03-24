package com.mybookshelf.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import kotlinx.coroutines.Dispatchers;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.zip.ZipInputStream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/mybookshelf/util/BookContent;", "", "()V", "EpubContent", "PdfPages", "TextContent", "Lcom/mybookshelf/util/BookContent$EpubContent;", "Lcom/mybookshelf/util/BookContent$PdfPages;", "Lcom/mybookshelf/util/BookContent$TextContent;", "app_debug"})
public abstract class BookContent {
    
    private BookContent() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/mybookshelf/util/BookContent$EpubContent;", "Lcom/mybookshelf/util/BookContent;", "chapters", "", "Lcom/mybookshelf/util/Chapter;", "toc", "Lcom/mybookshelf/util/TocItem;", "(Ljava/util/List;Ljava/util/List;)V", "getChapters", "()Ljava/util/List;", "getToc", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class EpubContent extends com.mybookshelf.util.BookContent {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.mybookshelf.util.Chapter> chapters = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.mybookshelf.util.TocItem> toc = null;
        
        public EpubContent(@org.jetbrains.annotations.NotNull()
        java.util.List<com.mybookshelf.util.Chapter> chapters, @org.jetbrains.annotations.NotNull()
        java.util.List<com.mybookshelf.util.TocItem> toc) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mybookshelf.util.Chapter> getChapters() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mybookshelf.util.TocItem> getToc() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mybookshelf.util.Chapter> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mybookshelf.util.TocItem> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mybookshelf.util.BookContent.EpubContent copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.mybookshelf.util.Chapter> chapters, @org.jetbrains.annotations.NotNull()
        java.util.List<com.mybookshelf.util.TocItem> toc) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012$\u0010\u0004\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J,\u0010\u0010\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ@\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032&\b\u0002\u0010\u0004\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R1\u0010\u0004\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/mybookshelf/util/BookContent$PdfPages;", "Lcom/mybookshelf/util/BookContent;", "totalPages", "", "renderPage", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Landroid/graphics/Bitmap;", "", "(ILkotlin/jvm/functions/Function2;)V", "getRenderPage", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getTotalPages", "()I", "component1", "component2", "copy", "(ILkotlin/jvm/functions/Function2;)Lcom/mybookshelf/util/BookContent$PdfPages;", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class PdfPages extends com.mybookshelf.util.BookContent {
        private final int totalPages = 0;
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function2<java.lang.Integer, kotlin.coroutines.Continuation<? super android.graphics.Bitmap>, java.lang.Object> renderPage = null;
        
        public PdfPages(int totalPages, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super kotlin.coroutines.Continuation<? super android.graphics.Bitmap>, ? extends java.lang.Object> renderPage) {
        }
        
        public final int getTotalPages() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function2<java.lang.Integer, kotlin.coroutines.Continuation<? super android.graphics.Bitmap>, java.lang.Object> getRenderPage() {
            return null;
        }
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function2<java.lang.Integer, kotlin.coroutines.Continuation<? super android.graphics.Bitmap>, java.lang.Object> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mybookshelf.util.BookContent.PdfPages copy(int totalPages, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super kotlin.coroutines.Continuation<? super android.graphics.Bitmap>, ? extends java.lang.Object> renderPage) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/mybookshelf/util/BookContent$TextContent;", "Lcom/mybookshelf/util/BookContent;", "pages", "", "", "(Ljava/util/List;)V", "getPages", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class TextContent extends com.mybookshelf.util.BookContent {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> pages = null;
        
        public TextContent(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> pages) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getPages() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mybookshelf.util.BookContent.TextContent copy(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> pages) {
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
}