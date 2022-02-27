package com.danielwaiguru.presentation.dashboard

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.danielwaiguru.presentation.R
import com.danielwaiguru.presentation.adapters.DashBoardPagerAdapter
import com.danielwaiguru.presentation.databinding.FragmentDashBoardBinding
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.jar.Manifest

class DashBoardFragment : Fragment(R.layout.fragment_dash_board) {
    private var _binding: FragmentDashBoardBinding? = null
    private val binding: FragmentDashBoardBinding get() = _binding!!
    private val titles: Array<String> by lazy {
        resources.getStringArray(R.array.pager_titles)
    }
    private val viewModel: DashBoardViewModel by viewModel()
    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDashBoardBinding.bind(view)
        initUI()
    }

    private fun initUI() {
        permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
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

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED) {
            permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
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