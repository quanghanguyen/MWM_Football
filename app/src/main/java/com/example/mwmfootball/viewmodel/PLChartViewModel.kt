package com.example.mwmfootball.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.Chart.PLChartModel
import com.example.mwmfootball.retrofit.PL.PLChart
import com.example.mwmfootball.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PLChartViewModel : ViewModel(){

    private var lstChartPL : MutableLiveData<PLChartModel?> = MutableLiveData()

    fun getListChartObserver() : MutableLiveData<PLChartModel?> {
        return lstChartPL
    }

    fun makeChartAPICall() {
        val chartData = RetrofitInstance.getRetrofitInstace().create(PLChart::class.java)
        val callPLChart = chartData.getPLChart

        callPLChart.enqueue(object : Callback<PLChartModel?> {
            override fun onResponse(call: Call<PLChartModel?>, response: Response<PLChartModel?>) {
                if (response.isSuccessful) {
                    lstChartPL.postValue(response.body())
                } else {
                    lstChartPL.postValue(null)
                }
            }

            override fun onFailure(call: Call<PLChartModel?>, t: Throwable) {
                lstChartPL.postValue(null)
            }
        })
    }

}