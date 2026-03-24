package com.mybookshelf.ui.screens.reader;

import android.app.Application;
import com.mybookshelf.domain.repository.BookRepository;
import com.mybookshelf.domain.repository.BookmarkRepository;
import com.mybookshelf.domain.repository.NoteRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ReaderViewModel_Factory implements Factory<ReaderViewModel> {
  private final Provider<Application> applicationProvider;

  private final Provider<BookRepository> bookRepositoryProvider;

  private final Provider<BookmarkRepository> bookmarkRepositoryProvider;

  private final Provider<NoteRepository> noteRepositoryProvider;

  public ReaderViewModel_Factory(Provider<Application> applicationProvider,
      Provider<BookRepository> bookRepositoryProvider,
      Provider<BookmarkRepository> bookmarkRepositoryProvider,
      Provider<NoteRepository> noteRepositoryProvider) {
    this.applicationProvider = applicationProvider;
    this.bookRepositoryProvider = bookRepositoryProvider;
    this.bookmarkRepositoryProvider = bookmarkRepositoryProvider;
    this.noteRepositoryProvider = noteRepositoryProvider;
  }

  @Override
  public ReaderViewModel get() {
    return newInstance(applicationProvider.get(), bookRepositoryProvider.get(), bookmarkRepositoryProvider.get(), noteRepositoryProvider.get());
  }

  public static ReaderViewModel_Factory create(Provider<Application> applicationProvider,
      Provider<BookRepository> bookRepositoryProvider,
      Provider<BookmarkRepository> bookmarkRepositoryProvider,
      Provider<NoteRepository> noteRepositoryProvider) {
    return new ReaderViewModel_Factory(applicationProvider, bookRepositoryProvider, bookmarkRepositoryProvider, noteRepositoryProvider);
  }

  public static ReaderViewModel newInstance(Application application, BookRepository bookRepository,
      BookmarkRepository bookmarkRepository, NoteRepository noteRepository) {
    return new ReaderViewModel(application, bookRepository, bookmarkRepository, noteRepository);
  }
}
