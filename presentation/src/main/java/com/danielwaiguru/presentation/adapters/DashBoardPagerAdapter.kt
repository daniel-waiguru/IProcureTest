package com.danielwaiguru.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.danielwaiguru.presentation.dashboard.AllInventoriesFragment

class DashBoardPagerAdapter(
    fragmentActivity: FragmentActivity
): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> AllInventoriesFragment()
            else -> AllInventoriesFragment()
        }
    }
}