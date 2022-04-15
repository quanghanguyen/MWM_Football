package com.example.mwmfootball.viewmodel.PLViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.PLHomeData
import com.example.mwmfootball.retrofit.PL.PLHome
import com.example.mwmfootball.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PLHomeViewModel : ViewModel() {

    var plHomeData = MutableLiveData<PLHomeData?>()

    init {
        plHomeData = MutableLiveData()
    }
    fun getPLHomeDataObserver() : MutableLiveData<PLHomeData?> {
        return plHomeData
    }
    fun plHomeDataAPICall() {
        val plData = RetrofitInstance.getRetrofitInstace().create(PLHome::class.java)
        val plHomeCall = plData.plHomeData
        plHomeCall.enqueue(object : Callback<PLHomeData?> {
            override fun onResponse(call: Call<PLHomeData?>, response: Response<PLHomeData?>) {
                if (response.isSuccessful) {
                    plHomeData.postValue(response.body())
                } else {
                    plHomeData.postValue(null)
                }
            }

            override fun onFailure(call: Call<PLHomeData?>, t: Throwable) {
                plHomeData.postValue(null)
            }
        })
    }

}