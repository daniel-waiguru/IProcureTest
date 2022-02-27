package com.danielwaiguru.domain.repositories

import com.danielwaiguru.domain.models.Product
import com.danielwaiguru.domain.models.ProductUiModel
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    /**
     * Stores Product in the db
     */
    suspend fun addProduct(product: Product): Long

    /**
     * Retrieves all products
     */
    fun getAllProducts(): Flow<List<ProductUiModel>>

    /**
     * Retrieves products by category
     */
    fun getProductsByCategory(category: String): Flow<List<ProductUiModel>>

    /**
     * Searching a Product
     */
    fun searchProduct(searchQuery: String): Flow<List<ProductUiModel>>
}