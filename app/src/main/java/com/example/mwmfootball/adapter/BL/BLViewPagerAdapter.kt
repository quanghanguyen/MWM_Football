package com.example.mwmfootball.adapter.BL

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mwmfootball.fragment.BL.BLChartFragment
import com.example.mwmfootball.fragment.BL.BLTeamsFragment

class BLViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                BLTeamsFragment()
            }
            1 -> {
                BLChartFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}