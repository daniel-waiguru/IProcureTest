package com.danielwaiguru.presentation.products

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.danielwaiguru.presentation.R
import com.danielwaiguru.presentation.adapters.ProductsAdapter
import com.danielwaiguru.presentation.databinding.FragmentAllInventoriesBinding
import com.danielwaiguru.presentation.utils.snackBar
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllInventoriesFragment : Fragment(R.layout.fragment_all_inventories) {
    private var _binding: FragmentAllInventoriesBinding? = null
    private val binding: FragmentAllInventoriesBinding get() = _binding!!
    private val viewModel: ProductsViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAllInventoriesBinding.bind(view)
        initUI()
    }

    private fun initUI() {
        getData()
        val adapter = createAdapter()
        setupRecyclerView(adapter)
        observeViewState(adapter)
    }

    private fun getData() {
        viewModel.getProducts(arguments?.getString(CATEGORY_TAG))
    }

    private fun observeViewState(productsAdapter: ProductsAdapter) {
        lifecycleScope.launch {

            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.productsState.collect {
                    Log.i("TEST", "Products are ${it.products}")
                    showLoading(it.isLoading)
                    binding.tvEmpty.isVisible = it.products.isEmpty()
                    productsAdapter.submitList(it.products)
                    if (it.errorMessage != null) {
                        snackBar(it.errorMessage, Color.RED)
                    }
                }
            }

        }
    }
    private fun showLoading(isLoading: Boolean) {
        with(binding) {
            productsRv.isVisible = !isLoading
            progressBar.isVisible = isLoading
        }
    }

    private fun setupRecyclerView(productsAdapter: ProductsAdapter) {
        binding.productsRv.apply {
            adapter = productsAdapter
            setHasFixedSize(true)
        }
    }

    private fun createAdapter(): ProductsAdapter {
        return ProductsAdapter()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param category Parameter 1.
         * @return A new instance of fragment AllInventoriesFragment.
         */
        @JvmStatic
        fun newInstance(category: String) =
            AllInventoriesFragment().apply {
                arguments = Bundle().apply {
                    putString(CATEGORY_TAG, category)
                }
            }

        private const val CATEGORY_TAG = "CATEGORY_TAG"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}