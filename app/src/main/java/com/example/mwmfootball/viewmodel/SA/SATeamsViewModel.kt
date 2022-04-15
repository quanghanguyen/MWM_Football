package com.example.mwmfootball.viewmodel.SA

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.Teams.PLTeamsModel
import com.example.mwmfootball.retrofit.RetrofitInstance
import com.example.mwmfootball.retrofit.SA.SATeams
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SATeamsViewModel : ViewModel() {

    private val lstSATeams : MutableLiveData<PLTeamsModel?> = MutableLiveData()

    fun getListSATeamsDataObserver() : MutableLiveData<PLTeamsModel?> {
        return lstSATeams
    }
    fun makeSAListAPICall() {
        val lstSATeam = RetrofitInstance.getRetrofitInstace().create(SATeams::class.java)
        val callSATeam = lstSATeam.callBLTeams

        callSATeam.enqueue(object : Callback<PLTeamsModel?> {
            override fun onResponse(call: Call<PLTeamsModel?>, response: Response<PLTeamsModel?>) {
                if (response.isSuccessful) {
                    lstSATeams.postValue(response.body())
                } else {
                    lstSATeams.postValue(null)
                }
            }

            override fun onFailure(call: Call<PLTeamsModel?>, t: Throwable) {
                lstSATeams.postValue(null)
            }
        })
    }

}