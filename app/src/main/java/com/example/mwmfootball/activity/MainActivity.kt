package com.example.mwmfootball.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mwmfootball.R
import com.example.mwmfootball.databinding.ActivityMainBinding
import com.example.mwmfootball.model.PLHomeData
import com.example.mwmfootball.retrofit.PL.PLHome
import com.example.mwmfootball.viewmodel.PLViewModel.PLHomeViewModel

// OnClick trên Cardview thì lỗi crash

lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

        //
        callPlHomeData()

        //onClick
        plClick()
    }

    private fun plClick() {
        binding.cvPL.setOnClickListener {
            val intent = Intent(this@MainActivity, PLHome::class.java)
            startActivity(intent)
        }
    }

    private fun callPlHomeData() {
        val plHomeViewModel: PLHomeViewModel by viewModels()
        plHomeViewModel.getPLHomeDataObserver().observe(this, Observer<PLHomeData?> {
            if (it != null) {
                binding.tvNamePL.text = it.name
                binding.tvstartDate.text = it.currentSeason.startDate
                binding.tvendDate.text = it.currentSeason.endDate
                binding.tvmatchDay.text = it.currentSeason.currentMatchday.toString()

            }
        })
        plHomeViewModel.plHomeDataAPICall()
    }

}
