package com.example.mwmfootball.viewmodel.BLViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.PLHomeData
import com.example.mwmfootball.retrofit.BL.BLHome
import com.example.mwmfootball.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BLHomeViewModel : ViewModel() {

    var blHomeData : MutableLiveData<PLHomeData?> = MutableLiveData()

    fun getBLHomeDataObserver() : MutableLiveData<PLHomeData?>{
        return blHomeData
    }

    fun makeBLHomeDataCall() {
        val blHome = RetrofitInstance.getRetrofitInstace().create(BLHome::class.java)
        val callBLHome = blHome.getBLHomeData

        callBLHome.enqueue(object : Callback<PLHomeData?> {
            override fun onResponse(call: Call<PLHomeData?>, response: Response<PLHomeData?>) {
                if (response.isSuccessful) {
                    blHomeData.postValue(response.body())
                } else {
                    blHomeData.postValue(null)
                }
            }

            override fun onFailure(call: Call<PLHomeData?>, t: Throwable) {
                blHomeData.postValue(null)
            }
        })
    }



}