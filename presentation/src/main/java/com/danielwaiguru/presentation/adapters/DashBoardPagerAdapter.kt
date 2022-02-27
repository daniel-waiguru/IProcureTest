package com.danielwaiguru.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.danielwaiguru.presentation.products.AllInventoriesFragment

class DashBoardPagerAdapter(
    fragmentActivity: FragmentActivity
): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> AllInventoriesFragment()
            1 -> AllInventoriesFragment.newInstance("Cereal Seeds")
            2 -> AllInventoriesFragment.newInstance("Equipment")
            3 -> AllInventoriesFragment.newInstance("Minerals")
            else -> AllInventoriesFragment()
        }
    }
}