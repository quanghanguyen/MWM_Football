package com.example.mwmfootball.viewmodel.L1ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.Chart.PLChartModel
import com.example.mwmfootball.retrofit.L1.L1Chart
import com.example.mwmfootball.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class L1ChartViewModel : ViewModel() {

    private var lstL1Chart : MutableLiveData<PLChartModel?> = MutableLiveData()

    fun getListL1ChartDataObserver() : MutableLiveData<PLChartModel?> {
        return lstL1Chart
    }
    fun makeL1ChartDataCall() {
        val l1ChartData = RetrofitInstance.getRetrofitInstace().create(L1Chart::class.java)
        val callL1Chart = l1ChartData.getL1ChartData

        callL1Chart.enqueue(object : Callback<PLChartModel?> {
            override fun onResponse(call: Call<PLChartModel?>, response: Response<PLChartModel?>) {
                if (response.isSuccessful) {
                    lstL1Chart.postValue(response.body())
                } else {
                    lstL1Chart.postValue(null)
                }
            }

            override fun onFailure(call: Call<PLChartModel?>, t: Throwable) {
                lstL1Chart.postValue(null)
            }
        })
    }

}