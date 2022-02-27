package com.danielwaiguru.presentation.add_items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danielwaiguru.presentation.R
import com.danielwaiguru.presentation.databinding.FragmentAddInventoryBinding

class AddInventoryFragment : Fragment(R.layout.fragment_add_inventory) {
    private var _binding: FragmentAddInventoryBinding? = null
    private val binding: FragmentAddInventoryBinding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddInventoryBinding.bind(view)
        initUi()
    }

    private fun initUi() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}