package com.example.mwmfootball.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mwmfootball.R
import com.example.mwmfootball.activity.BL.BLHome
import com.example.mwmfootball.activity.L1.L1Home
import com.example.mwmfootball.activity.SA.SAHome
import com.example.mwmfootball.databinding.ActivityMainBinding
import com.example.mwmfootball.model.PLHomeData
import com.example.mwmfootball.retrofit.PL.PLHome
import com.example.mwmfootball.viewmodel.BLViewModel.BLHomeViewModel
import com.example.mwmfootball.viewmodel.L1ViewModel.L1HomeViewModel
import com.example.mwmfootball.viewmodel.PLViewModel.PLHomeViewModel
import com.example.mwmfootball.viewmodel.SA.SAHomeViewModel

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
        callL1HomeData()
        callBLHomeData()
        callSAHomeData()

        //onClick
        plClick()
        l1Click()
        blClick()
        saClick()
    }

    private fun saClick() {
        binding.cvSA.setOnClickListener {
            val intent = Intent(this@MainActivity, SAHome::class.java)
            startActivity(intent)
        }
    }

    private fun callSAHomeData() {
        val saHomeViewModel : SAHomeViewModel by viewModels()
        saHomeViewModel.saHomeDataObserver().observe(this, Observer<PLHomeData?>{
            if (it != null) {
                binding.tvNameSA.text = it.name
                binding.tvstartDate3.text = it.currentSeason.startDate
                binding.tvendDate3.text = it.currentSeason.endDate
                binding.tvmatchDay3.text = it.currentSeason.currentMatchday.toString()
            }
        })

        saHomeViewModel.makeSAHomeDataCall()

    }

    private fun blClick() {
        binding.cvBL.setOnClickListener {
            val intent = Intent(this@MainActivity, BLHome::class.java)
            startActivity(intent)
        }
    }

    private fun callBLHomeData() {
        val blHomeViewModel : BLHomeViewModel by viewModels()
        blHomeViewModel.getBLHomeDataObserver().observe(this, Observer<PLHomeData?>{
            if (it != null) {
                binding.tvNameBL.text = it.name
                binding.tvstartDate2.text = it.currentSeason.startDate
                binding.tvendDate3.text = it.currentSeason.endDate
                binding.tvmatchDay2.text = it.currentSeason.currentMatchday.toString()
            }
        })
        blHomeViewModel.makeBLHomeDataCall()
    }

    private fun l1Click() {
        binding.cvL1.setOnClickListener {
            val intent = Intent(this@MainActivity, L1Home::class.java)
            startActivity(intent)
        }
    }

    private fun callL1HomeData() {
        val l1HomeViewModel : L1HomeViewModel by viewModels()
        l1HomeViewModel.getL1HomeDataObserver().observe(this, Observer<PLHomeData?>{
            if (it != null) {
                binding.tvNameL1.text = it.name
                binding.tvstartDate1.text = it.currentSeason.startDate
                binding.tvendDate1.text = it.currentSeason.endDate
                binding.tvmatchDay1.text = it.currentSeason.currentMatchday.toString()
            }
        })

        l1HomeViewModel.makeL1HomeDataCall()
    }

    private fun plClick() {
        binding.cvPL.setOnClickListener {
            val intent = Intent(this@MainActivity, com.example.mwmfootball.activity.PL.PLHome::class.java)
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
