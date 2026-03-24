package com.mybookshelf.data.repository;

import com.mybookshelf.data.local.dao.BookmarkDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class BookmarkRepositoryImpl_Factory implements Factory<BookmarkRepositoryImpl> {
  private final Provider<BookmarkDao> bookmarkDaoProvider;

  public BookmarkRepositoryImpl_Factory(Provider<BookmarkDao> bookmarkDaoProvider) {
    this.bookmarkDaoProvider = bookmarkDaoProvider;
  }

  @Override
  public BookmarkRepositoryImpl get() {
    return newInstance(bookmarkDaoProvider.get());
  }

  public static BookmarkRepositoryImpl_Factory create(Provider<BookmarkDao> bookmarkDaoProvider) {
    return new BookmarkRepositoryImpl_Factory(bookmarkDaoProvider);
  }

  public static BookmarkRepositoryImpl newInstance(BookmarkDao bookmarkDao) {
    return new BookmarkRepositoryImpl(bookmarkDao);
  }
}
