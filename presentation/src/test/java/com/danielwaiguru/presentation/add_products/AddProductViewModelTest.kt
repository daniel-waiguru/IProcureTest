package com.danielwaiguru.presentation.add_products

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.danielwaiguru.domain.repositories.ProductRepository
import com.danielwaiguru.presentation.base.BaseViewModelTest
import com.danielwaiguru.presentation.product
import com.danielwaiguru.presentation.search.SearchViewModel
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddProductViewModelTest : BaseViewModelTest() {
    private val productRepository = mockk<ProductRepository>()
    private lateinit var addProductViewModel: AddProductViewModel

    @Before
    fun setUp() {
        addProductViewModel = AddProductViewModel(productRepository)
    }

    @Test
    fun `test adding a new product`() {
        coEvery {
            productRepository.addProduct(product)
        } returns 1L
        addProductViewModel.addProduct(product)
        coVerify { productRepository.addProduct(product) }
    }
}