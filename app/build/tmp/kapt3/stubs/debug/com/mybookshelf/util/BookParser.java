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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J2\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018H\u0002J#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u0011J#\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001c\u0010\u0011J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\""}, d2 = {"Lcom/mybookshelf/util/BookParser;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "parseBook", "Lkotlin/Result;", "Lcom/mybookshelf/util/BookContent;", "filePath", "", "format", "parseBook-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseEpub", "uri", "Landroid/net/Uri;", "parseEpub-IoAF18A", "(Landroid/net/Uri;)Ljava/lang/Object;", "parseOpf", "", "opfContent", "manifest", "", "spine", "", "parsePdf", "parsePdf-IoAF18A", "parseText", "parseText-IoAF18A", "splitIntoPages", "", "content", "charsPerPage", "", "app_debug"})
public final class BookParser {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    public BookParser(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final void parseOpf(java.lang.String opfContent, java.util.Map<java.lang.String, java.lang.String> manifest, java.util.List<java.lang.String> spine) {
    }
    
    private final java.util.List<java.lang.String> splitIntoPages(java.lang.String content, int charsPerPage) {
        return null;
    }
}