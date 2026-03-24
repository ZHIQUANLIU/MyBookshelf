package com.mybookshelf.data.repository;

import com.mybookshelf.data.local.dao.BookDao;
import com.mybookshelf.data.local.dao.CategoryDao;
import com.mybookshelf.data.local.dao.TagDao;
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
public final class BookRepositoryImpl_Factory implements Factory<BookRepositoryImpl> {
  private final Provider<BookDao> bookDaoProvider;

  private final Provider<CategoryDao> categoryDaoProvider;

  private final Provider<TagDao> tagDaoProvider;

  public BookRepositoryImpl_Factory(Provider<BookDao> bookDaoProvider,
      Provider<CategoryDao> categoryDaoProvider, Provider<TagDao> tagDaoProvider) {
    this.bookDaoProvider = bookDaoProvider;
    this.categoryDaoProvider = categoryDaoProvider;
    this.tagDaoProvider = tagDaoProvider;
  }

  @Override
  public BookRepositoryImpl get() {
    return newInstance(bookDaoProvider.get(), categoryDaoProvider.get(), tagDaoProvider.get());
  }

  public static BookRepositoryImpl_Factory create(Provider<BookDao> bookDaoProvider,
      Provider<CategoryDao> categoryDaoProvider, Provider<TagDao> tagDaoProvider) {
    return new BookRepositoryImpl_Factory(bookDaoProvider, categoryDaoProvider, tagDaoProvider);
  }

  public static BookRepositoryImpl newInstance(BookDao bookDao, CategoryDao categoryDao,
      TagDao tagDao) {
    return new BookRepositoryImpl(bookDao, categoryDao, tagDao);
  }
}
