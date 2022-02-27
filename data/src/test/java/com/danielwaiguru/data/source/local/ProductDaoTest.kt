package com.danielwaiguru.data.source.local

import androidx.lifecycle.asLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.danielwaiguru.data.base.BaseTest
import com.danielwaiguru.data.productEntity
import com.jraska.livedata.test
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class ProductDaoTest: BaseTest() {
    @Test
    fun `test inserting and retrieving products`() = runBlockingTest {
        val expectedId = productEntity.id
        productDao.insertProduct(productEntity)
        val products = productDao.getAllProducts().asLiveData()
        products.test().assertValue {
            it[0].id == expectedId
        }
    }
    @Test
    fun `test retrieving products by category`() = runBlockingTest {
        productDao.insertProduct(productEntity)
        val products = productDao.getProductsByCategory("category").asLiveData()
        products.test().assertValue(listOf(productEntity))
    }

    @Test
    fun `test searching a product`() = runBlockingTest {
        productDao.insertProduct(productEntity)
        val products = productDao.searchProduct("name").asLiveData()
        products.test().assertValue {
            it[0].name == "name"
        }
    }
}