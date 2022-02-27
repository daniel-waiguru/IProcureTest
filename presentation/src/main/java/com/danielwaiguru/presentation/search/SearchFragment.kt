package com.danielwaiguru.presentation.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import com.danielwaiguru.presentation.R
import com.danielwaiguru.presentation.adapters.ProductsAdapter
import com.danielwaiguru.presentation.databinding.FragmentSearchBinding
import com.danielwaiguru.presentation.utils.onQueryTextChanged
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(R.layout.fragment_search) {
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!
    private val viewModel: SearchViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)
        initUI()
    }

    private fun initUI() {
        setupSearchView()
        val adapter = createAdapter()
        setupRecyclerView(adapter)
        observeViewState(adapter)
        searchProduct()
    }

    private fun setupSearchView() {
        binding.searchView.requestFocus()
    }

    private fun observeViewState(productsAdapter: ProductsAdapter) {
        viewModel.allProducts.observe(viewLifecycleOwner) {
            Log.i("SEARCH", "Search is $it")
            binding.emptyState.isVisible = it.isEmpty()
            productsAdapter.submitList(it)
        }
    }
    private fun searchProduct() {
        binding.searchView.onQueryTextChanged {
            viewModel.searchQuery.value = it
        }
    }
    private fun setupRecyclerView(productsAdapter: ProductsAdapter) {
        binding.searchRv.apply {
            adapter = productsAdapter
            setHasFixedSize(true)
        }
    }

    private fun createAdapter(): ProductsAdapter {
        return ProductsAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}