package com.example.mwmfootball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mwmfootball.adapter.PLViewPagerAdapter
import com.example.mwmfootball.databinding.ActivityPlhomeBinding
import com.google.android.material.tabs.TabLayoutMediator

private lateinit var tlBinding: ActivityPlhomeBinding

class PLHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plhome)
        supportActionBar?.hide()

        tlBinding = ActivityPlhomeBinding.inflate(layoutInflater)
        setContentView(tlBinding.root)

        val vpAdapterPL = PLViewPagerAdapter(supportFragmentManager, lifecycle)

        tlBinding.vpPL.adapter = vpAdapterPL
        TabLayoutMediator(tlBinding.tlPL, tlBinding.vpPL){ tab, position ->
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