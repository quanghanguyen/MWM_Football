package com.example.mwmfootball.adapter.SA

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mwmfootball.fragment.SA.SAChartFragment
import com.example.mwmfootball.fragment.SA.SATeamsFragment

class SAViewPagerAdapter (fragmentManager : FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                SATeamsFragment()
            }
            1 -> {
                SAChartFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}