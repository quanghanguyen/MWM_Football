package com.example.mwmfootball.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.Teams.PLTeamsModel
import com.example.mwmfootball.retrofit.PL.PLTeams
import com.example.mwmfootball.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PLChartViewModel : ViewModel() {

    var lstPLTeams : MutableLiveData<PLTeamsModel?> = MutableLiveData()

    fun getListPLTeamsObserver() : MutableLiveData<PLTeamsModel?> {
        return lstPLTeams
    }

    fun makeTeamsAPICall() {
        val lstPLData = RetrofitInstance.getRetrofitInstace().create(PLTeams::class.java)
        val callPLTeamsData = lstPLData.getPLTeamsData

        callPLTeamsData.enqueue(object : Callback<PLTeamsModel?> {
            override fun onResponse(call: Call<PLTeamsModel?>, response: Response<PLTeamsModel?>) {
                if (response.isSuccessful) {
                    lstPLTeams.postValue(response.body())
                } else {
                    lstPLTeams.postValue(null)
                }
            }

            override fun onFailure(call: Call<PLTeamsModel?>, t: Throwable) {
                lstPLTeams.postValue(null)
            }
        })
    }

}