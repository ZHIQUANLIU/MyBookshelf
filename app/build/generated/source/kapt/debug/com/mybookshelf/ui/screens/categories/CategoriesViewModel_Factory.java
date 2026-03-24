package com.mybookshelf.ui.screens.categories;

import com.mybookshelf.domain.repository.BookRepository;
import com.mybookshelf.domain.repository.CategoryRepository;
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
public final class CategoriesViewModel_Factory implements Factory<CategoriesViewModel> {
  private final Provider<CategoryRepository> categoryRepositoryProvider;

  private final Provider<BookRepository> bookRepositoryProvider;

  public CategoriesViewModel_Factory(Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<BookRepository> bookRepositoryProvider) {
    this.categoryRepositoryProvider = categoryRepositoryProvider;
    this.bookRepositoryProvider = bookRepositoryProvider;
  }

  @Override
  public CategoriesViewModel get() {
    return newInstance(categoryRepositoryProvider.get(), bookRepositoryProvider.get());
  }

  public static CategoriesViewModel_Factory create(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<BookRepository> bookRepositoryProvider) {
    return new CategoriesViewModel_Factory(categoryRepositoryProvider, bookRepositoryProvider);
  }

  public static CategoriesViewModel newInstance(CategoryRepository categoryRepository,
      BookRepository bookRepository) {
    return new CategoriesViewModel(categoryRepository, bookRepository);
  }
}
