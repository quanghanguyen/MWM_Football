package com.example.mwmfootball.adapter.L1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mwmfootball.fragment.L1.L1ChartFragment
import com.example.mwmfootball.fragment.L1.L1TeamsFragment

class L1ViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                L1TeamsFragment()
            }
            1 -> {
                L1ChartFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}