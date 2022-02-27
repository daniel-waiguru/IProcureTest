package com.danielwaiguru.data.repositories

import androidx.lifecycle.asLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.danielwaiguru.data.base.BaseTest
import com.danielwaiguru.data.mappers.toUiModel
import com.danielwaiguru.data.product
import com.danielwaiguru.data.productEntity
import com.danielwaiguru.domain.repositories.ProductRepository
import com.jraska.livedata.test
import junit.framework.TestCase
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductRepositoryImplTest : BaseTest() {
    private lateinit var productRepository: ProductRepository
    private val testDispatcher = TestCoroutineDispatcher()
    private val scope = TestCoroutineScope(testDispatcher)
    override fun setup() {
        super.setup()
        productRepository = ProductRepositoryImpl(productDao)
    }
    @Test
    fun `test adding a product`() = runBlockingTest {
        productRepository.addProduct(product)
        val data = productRepository.getAllProducts().asLiveData()
        data.test().assertValue {
            it.contains(productEntity.toUiModel())
        }
    }

    @Test
    fun `test retrieving products by category`() = runBlockingTest {
        productRepository.addProduct(product)
        val data = productRepository.getProductsByCategory("category").asLiveData()
        data.test().assertValue(listOf(productEntity.toUiModel()))

    }
}