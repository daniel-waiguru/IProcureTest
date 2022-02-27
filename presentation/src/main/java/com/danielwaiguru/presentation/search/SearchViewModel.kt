package com.danielwaiguru.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.danielwaiguru.domain.models.ProductUiModel
import com.danielwaiguru.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class SearchViewModel(private val productRepository: ProductRepository): ViewModel() {
    val searchQuery = MutableStateFlow(" ")

    private val productsFlow = searchQuery.flatMapLatest {
        productRepository.searchProduct(it)
    }

    val allProducts: LiveData<List<ProductUiModel>> = productsFlow.asLiveData()
}