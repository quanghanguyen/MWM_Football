package com.example.mwmfootball.viewmodel.L1ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.PLHomeData
import com.example.mwmfootball.retrofit.L1.L1Home
import com.example.mwmfootball.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class L1HomeViewModel : ViewModel() {

    var l1HomeData = MutableLiveData<PLHomeData?>()

    init {
        l1HomeData = MutableLiveData()
    }

    fun getL1HomeDataObserver() : MutableLiveData<PLHomeData?>{
        return l1HomeData
    }

    fun makeL1HomeDataCall() {
        val l1Home = RetrofitInstance.getRetrofitInstace().create(L1Home::class.java)
        val l1HomeCall = l1Home.getL1Home

        l1HomeCall.enqueue(object : Callback<PLHomeData?> {
            override fun onResponse(call: Call<PLHomeData?>, response: Response<PLHomeData?>) {
                if (response.isSuccessful) {
                    l1HomeData.postValue(response.body())
                } else {
                    l1HomeData.postValue(null)
                }

            }

            override fun onFailure(call: Call<PLHomeData?>, t: Throwable) {
                l1HomeData.postValue(null)
            }
        })
    }

}