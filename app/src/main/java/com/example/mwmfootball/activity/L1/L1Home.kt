package com.example.mwmfootball.activity.L1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mwmfootball.R
import com.example.mwmfootball.adapter.L1.L1ViewPagerAdapter
import com.example.mwmfootball.databinding.ActivityL1HomeBinding
import com.google.android.material.tabs.TabLayoutMediator

private lateinit var l1HomeBinding: ActivityL1HomeBinding

class L1Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l1_home)
        supportActionBar?.hide()

        l1ViewBinding()
        setTabLayout()
    }

    private fun setTabLayout() {
        val l1ViewPagerAdapter = L1ViewPagerAdapter(supportFragmentManager, lifecycle)
        l1HomeBinding.vpL1.adapter = l1ViewPagerAdapter

        TabLayoutMediator(l1HomeBinding.tlL1, l1HomeBinding.vpL1) {tab, position ->
            when (position) {
                0 -> {
                    tab.text = "TEAMS"
                }
                1 -> {
                    tab.text = "CHART"
                }
            }
        }.attach()
    }

    private fun l1ViewBinding() {
        l1HomeBinding = ActivityL1HomeBinding.inflate(layoutInflater)
        setContentView(l1HomeBinding.root)
    }
}