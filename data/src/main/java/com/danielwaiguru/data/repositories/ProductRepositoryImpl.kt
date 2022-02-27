package com.danielwaiguru.data.repositories

import com.danielwaiguru.data.mappers.toEntity
import com.danielwaiguru.data.mappers.toUiModel
import com.danielwaiguru.data.source.local.ProductDao
import com.danielwaiguru.domain.models.Product
import com.danielwaiguru.domain.models.ProductUiModel
import com.danielwaiguru.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class ProductRepositoryImpl(private val productDao: ProductDao): ProductRepository {
    override suspend fun addProduct(product: Product) =
        productDao.insertProduct(product.toEntity())

    override fun getAllProducts(): Flow<List<ProductUiModel>> =
        productDao.getAllProducts().map { entities ->
            entities.map {
                it.toUiModel()
            }
        }

    override fun getProductsByCategory(category: String): Flow<List<ProductUiModel>> =
        productDao.getProductsByCategory(category).map { entities ->
            entities.map {
                it.toUiModel()
            }
        }

    override fun searchProduct(searchQuery: String): Flow<List<ProductUiModel>> =
        productDao.searchProduct(searchQuery).map { entities ->
            entities.map {
                it.toUiModel()
            }
        }
}