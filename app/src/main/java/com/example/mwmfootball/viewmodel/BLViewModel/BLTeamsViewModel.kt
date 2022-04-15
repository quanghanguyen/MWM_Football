package com.example.mwmfootball.viewmodel.BLViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.Teams.PLTeamsModel
import com.example.mwmfootball.retrofit.BL.BLTeams
import com.example.mwmfootball.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BLTeamsViewModel : ViewModel() {

    var lstBLTeams : MutableLiveData<PLTeamsModel?> = MutableLiveData()

    fun getListBLTeamsDataObserver() : MutableLiveData<PLTeamsModel?> {
        return lstBLTeams
    }

    fun makeBLTeamsAPICall() {
        val blTeamsData = RetrofitInstance.getRetrofitInstace().create(BLTeams::class.java)
        val callBLTeams = blTeamsData.callBLTeams

        callBLTeams.enqueue(object : Callback<PLTeamsModel?> {
            override fun onResponse(call: Call<PLTeamsModel?>, response: Response<PLTeamsModel?>) {
                if (response.isSuccessful) {
                    lstBLTeams.postValue(response.body())
                } else {
                    lstBLTeams.postValue(null)
                }
            }

            override fun onFailure(call: Call<PLTeamsModel?>, t: Throwable) {
                lstBLTeams.postValue(null)
            }
        })
    }

}