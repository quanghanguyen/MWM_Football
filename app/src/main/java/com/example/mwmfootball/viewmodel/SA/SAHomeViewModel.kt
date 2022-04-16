package com.example.mwmfootball.viewmodel.SA

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.PLHomeData
import com.example.mwmfootball.retrofit.RetrofitInstance
import com.example.mwmfootball.retrofit.SA.SAHome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SAHomeViewModel : ViewModel() {

    var saHomeData : MutableLiveData<PLHomeData?> = MutableLiveData()

    fun saHomeDataObserver() : MutableLiveData<PLHomeData?> {
        return saHomeData
    }

    fun makeSAHomeDataCall() {
        val saHome = RetrofitInstance.getRetrofitInstace().create(SAHome::class.java)
        val saHomeDataCall = saHome.getSAHome

        saHomeDataCall.enqueue(object : Callback<PLHomeData?> {
            override fun onResponse(call: Call<PLHomeData?>, response: Response<PLHomeData?>) {
                if (response.isSuccessful) {
                    saHomeData.postValue(response.body())
                } else {
                    saHomeData.postValue(null)
                }
            }

            override fun onFailure(call: Call<PLHomeData?>, t: Throwable) {
                saHomeData.postValue(null)
            }
        })
    }

}