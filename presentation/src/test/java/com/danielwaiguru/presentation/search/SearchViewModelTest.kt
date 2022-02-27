package com.danielwaiguru.presentation.search

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.danielwaiguru.data.mappers.toUiModel
import com.danielwaiguru.domain.repositories.ProductRepository
import com.danielwaiguru.presentation.base.BaseViewModelTest
import com.danielwaiguru.presentation.productEntity
import com.jraska.livedata.test
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchViewModelTest : BaseViewModelTest() {
    private val productRepository = mockk<ProductRepository>()
    private lateinit var searchViewModel: SearchViewModel

    @Before
    fun setUp() {
        searchViewModel = SearchViewModel(productRepository)
    }

    @Test
    fun `test searching a product`() {
        coEvery { productRepository.searchProduct(" ")
        } returns flowOf(listOf(productEntity.toUiModel()))
        searchViewModel.allProducts
        searchViewModel.allProducts.test().assertValue(listOf(productEntity.toUiModel()))
    }
}