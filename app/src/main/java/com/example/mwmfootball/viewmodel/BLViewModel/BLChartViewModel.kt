package com.example.mwmfootball.viewmodel.BLViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.Chart.PLChartModel
import com.example.mwmfootball.retrofit.BL.BLChart
import com.example.mwmfootball.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BLChartViewModel : ViewModel() {

    private var lstBLChart : MutableLiveData<PLChartModel?> = MutableLiveData()

    fun getListBLChartDataObserver() : MutableLiveData<PLChartModel?> {
        return lstBLChart
    }

    fun makeBLChartCall() {
        val blChart = RetrofitInstance.getRetrofitInstace().create(BLChart::class.java)
        val callBLChart = blChart.callBLChart

        callBLChart.enqueue(object : Callback<PLChartModel?> {
            override fun onResponse(call: Call<PLChartModel?>, response: Response<PLChartModel?>) {
                if (response.isSuccessful) {
                    lstBLChart.postValue(response.body())
                } else {
                    lstBLChart.postValue(null)
                }
            }

            override fun onFailure(call: Call<PLChartModel?>, t: Throwable) {
                lstBLChart.postValue(null)
            }
        })
    }

}