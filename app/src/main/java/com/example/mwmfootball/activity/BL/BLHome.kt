package com.example.mwmfootball.activity.BL

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mwmfootball.R
import com.example.mwmfootball.adapter.BL.BLViewPagerAdapter
import com.example.mwmfootball.databinding.ActivityBlhomeBinding
import com.example.mwmfootball.databinding.ActivityL1HomeBinding
import com.google.android.material.tabs.TabLayoutMediator

private lateinit var blHomeBinding: ActivityBlhomeBinding

class BLHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blhome)
        supportActionBar?.hide()

        setViewBinding()
        setTabLayout()
    }

    private fun setViewBinding() {
        blHomeBinding = ActivityBlhomeBinding.inflate(layoutInflater)
        setContentView(blHomeBinding.root)
    }

    private fun setTabLayout() {
        val blViewPagerAdapter = BLViewPagerAdapter(supportFragmentManager, lifecycle)
        blHomeBinding.vpBL.adapter = blViewPagerAdapter

        TabLayoutMediator(blHomeBinding.tlBL, blHomeBinding.vpBL) {tab, position ->
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
}