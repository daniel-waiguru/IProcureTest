package com.danielwaiguru.presentation.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.danielwaiguru.presentation.R
import com.danielwaiguru.presentation.adapters.DashBoardPagerAdapter
import com.danielwaiguru.presentation.databinding.FragmentDashBoardBinding
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashBoardFragment : Fragment(R.layout.fragment_dash_board) {
    private var _binding: FragmentDashBoardBinding? = null
    private val binding: FragmentDashBoardBinding get() = _binding!!
    private val titles: Array<String> by lazy {
        resources.getStringArray(R.array.pager_titles)
    }
    private val viewModel: DashBoardViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDashBoardBinding.bind(view)
        initUI()
    }

    private fun initUI() {
        val adapter = createAdapter()
        setupPager2(adapter)
        initListeners()
        observeViewState()
    }

    private fun observeViewState() {
        viewModel.onAddInventoryClicked.observe(viewLifecycleOwner) {
            findNavController().navigate(
                DashBoardFragmentDirections.actionDashBoardFragmentToAddInventoryFragment()
            )
        }
    }

    private fun initListeners() {
        binding.addProduct.setOnClickListener {
            viewModel.onAddClicked()
        }
    }

    private fun setupPager2(adapter: DashBoardPagerAdapter) {
        with(binding) {
            pager.apply {
                this.adapter = adapter
            }
            TabLayoutMediator(tabLayout, pager){ tab, position ->
                tab.text = titles[position]
            }.attach()
        }
    }

    private fun createAdapter(): DashBoardPagerAdapter {
        return DashBoardPagerAdapter(requireActivity())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        /**
         * Nullify the binding instance to avoid memory leaks
         */
        _binding = null
    }
}