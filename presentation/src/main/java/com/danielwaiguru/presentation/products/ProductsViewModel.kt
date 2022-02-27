package com.danielwaiguru.presentation.products

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.danielwaiguru.domain.models.ProductUiModel
import com.danielwaiguru.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ProductsViewModel(private val productRepository: ProductRepository): ViewModel() {
    private val _productsState: MutableStateFlow<ProductsUiState> =
        MutableStateFlow(ProductsUiState())
    val productsState: StateFlow<ProductsUiState> get() = _productsState.asStateFlow()

    fun getProducts(category: String?) {
        Log.i("TEST", "$category")
        viewModelScope.launch {
            if (category == null) {
                productRepository.getAllProducts()
                    .onStart {
                        _productsState.update {
                            it.copy(isLoading = true)
                        }
                    }
                    .catch { exception ->
                        _productsState.update {
                            it.copy(errorMessage = exception.message, isLoading = false)
                        }
                    }
                    .collect { products ->
                        _productsState.update {
                            it.copy(products = products, isLoading = false)
                        }
                    }

            } else {
                productRepository.getProductsByCategory(category)
                    .onStart {
                        _productsState.update {
                            it.copy(isLoading = true)
                        }
                    }
                    .catch { exception ->
                        _productsState.update {
                            it.copy(errorMessage = exception.message, isLoading = false)
                        }
                    }
                    .collect { products ->
                        _productsState.update {
                            it.copy(products = products, isLoading = false)
                        }
                    }
            }
        }
    }
}
data class ProductsUiState(
    val products: List<ProductUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)