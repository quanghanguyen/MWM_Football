package com.example.mwmfootball.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mwmfootball.fragment.PLChartFragment
import com.example.mwmfootball.fragment.PLTeamsFragment

class PLViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                PLTeamsFragment()
            }
            1 -> {
                PLChartFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}