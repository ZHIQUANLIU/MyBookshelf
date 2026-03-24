package com.mybookshelf.di;

import com.mybookshelf.data.local.MyBookshelfDatabase;
import com.mybookshelf.data.local.dao.BookDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideBookDaoFactory implements Factory<BookDao> {
  private final Provider<MyBookshelfDatabase> databaseProvider;

  public DatabaseModule_ProvideBookDaoFactory(Provider<MyBookshelfDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public BookDao get() {
    return provideBookDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideBookDaoFactory create(
      Provider<MyBookshelfDatabase> databaseProvider) {
    return new DatabaseModule_ProvideBookDaoFactory(databaseProvider);
  }

  public static BookDao provideBookDao(MyBookshelfDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideBookDao(database));
  }
}
