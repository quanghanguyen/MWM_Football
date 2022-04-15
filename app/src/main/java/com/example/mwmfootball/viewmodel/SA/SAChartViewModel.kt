package com.example.mwmfootball.viewmodel.SA

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.Chart.PLChartModel
import com.example.mwmfootball.model.Teams.PLTeamsModel
import com.example.mwmfootball.retrofit.RetrofitInstance
import com.example.mwmfootball.retrofit.SA.SAChart
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SAChartViewModel : ViewModel() {

    private var lstSAChart : MutableLiveData<PLChartModel?> = MutableLiveData()

    fun getListSAChartDataObserver() : MutableLiveData<PLChartModel?> {
        return lstSAChart
    }

    fun makeSAChartAPICall() {
        val saChartData = RetrofitInstance.getRetrofitInstace().create(SAChart::class.java)
        val callSAChart = saChartData.callSAChart

        callSAChart.enqueue(object : Callback<PLChartModel?> {
            override fun onResponse(call: Call<PLChartModel?>, response: Response<PLChartModel?>) {
                if (response.isSuccessful) {
                    lstSAChart.postValue(response.body())
                } else {
                    lstSAChart.postValue(null)
                }
            }

            override fun onFailure(call: Call<PLChartModel?>, t: Throwable) {
                lstSAChart.postValue(null)
            }
        })
    }

}