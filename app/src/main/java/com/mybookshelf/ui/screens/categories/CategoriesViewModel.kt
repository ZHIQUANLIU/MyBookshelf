package com.mybookshelf.ui.screens.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mybookshelf.domain.model.Book
import com.mybookshelf.domain.model.Category
import com.mybookshelf.domain.repository.BookRepository
import com.mybookshelf.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CategoriesUiState(
    val categories: List<Category> = emptyList(),
    val books: List<Book> = emptyList(),
    val selectedCategory: Category? = null,
    val categoryBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true
)

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val bookRepository: BookRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CategoriesUiState())
    val uiState: StateFlow<CategoriesUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            combine(
                categoryRepository.getAllCategories(),
                bookRepository.getAllBooks()
            ) { categories, books ->
                _uiState.update {
                    it.copy(
                        categories = categories,
                        books = books,
                        isLoading = false
                    )
                }
            }.collect()
        }
    }

    fun addCategory(name: String, color: String) {
        viewModelScope.launch {
            categoryRepository.insertCategory(Category(name = name, color = color))
        }
    }

    fun deleteCategory(category: Category) {
        viewModelScope.launch {
            categoryRepository.deleteCategory(category)
        }
    }

    fun selectCategory(category: Category?) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    fun addBookToCategory(bookId: Long, categoryId: Long) {
        viewModelScope.launch {
            bookRepository.addCategoryToBook(bookId, categoryId)
        }
    }
}
