package com.mybookshelf.ui.screens.library;

import com.mybookshelf.domain.repository.BookRepository;
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
public final class LibraryViewModel_Factory implements Factory<LibraryViewModel> {
  private final Provider<BookRepository> bookRepositoryProvider;

  public LibraryViewModel_Factory(Provider<BookRepository> bookRepositoryProvider) {
    this.bookRepositoryProvider = bookRepositoryProvider;
  }

  @Override
  public LibraryViewModel get() {
    return newInstance(bookRepositoryProvider.get());
  }

  public static LibraryViewModel_Factory create(Provider<BookRepository> bookRepositoryProvider) {
    return new LibraryViewModel_Factory(bookRepositoryProvider);
  }

  public static LibraryViewModel newInstance(BookRepository bookRepository) {
    return new LibraryViewModel(bookRepository);
  }
}
