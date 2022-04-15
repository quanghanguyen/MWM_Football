package com.example.mwmfootball.viewmodel.L1ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.PLHomeData
import com.example.mwmfootball.retrofit.L1.L1Home
import com.example.mwmfootball.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class L1HomeViewModel : ViewModel() {

    var l1HomeData : MutableLiveData<PLHomeData?> = MutableLiveData()


    fun getL1HomeDataObserver() : MutableLiveData<PLHomeData?> {
        return l1HomeData
    }

    fun callL1HomeData() {
        val l1HomeData = RetrofitInstance.getRetrofitInstace().create(L1Home::class.java)
        val callL1Home = l1HomeData.getL1Home

        callL1Home.enqueue(object : Callback<PLHomeData?> {
            override fun onResponse(call: Call<PLHomeData?>, response: Response<PLHomeData?>) {
                if (response.isSuccessful) {

                }
            }

            override fun onFailure(call: Call<PLHomeData?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}