package com.example.mwmfootball.activity.SA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mwmfootball.R
import com.example.mwmfootball.adapter.SA.SAViewPagerAdapter
import com.example.mwmfootball.databinding.ActivitySahomeBinding
import com.google.android.material.tabs.TabLayoutMediator

private lateinit var saHomeBinding: ActivitySahomeBinding

class SAHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sahome)
        supportActionBar?.hide()

        saViewBinding()
        saSetViewPager()

    }

    private fun saSetViewPager() {
        val saViewPagerAdapter = SAViewPagerAdapter(supportFragmentManager, lifecycle)
        saHomeBinding.vpSA.adapter = saViewPagerAdapter

        TabLayoutMediator(saHomeBinding.tlSA, saHomeBinding.vpSA) {tab, position ->

            when (position) {
                0 -> {
                    tab.text = "TEAMS"
                }
                1 -> {
                    tab.text = "CHARTS"
                }
            }

        }.attach()
    }

    private fun saViewBinding() {
        saHomeBinding = ActivitySahomeBinding.inflate(layoutInflater)
        setContentView(saHomeBinding.root)
    }
}