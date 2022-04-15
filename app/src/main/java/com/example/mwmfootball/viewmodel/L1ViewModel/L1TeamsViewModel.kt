package com.example.mwmfootball.viewmodel.L1ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwmfootball.model.Teams.PLTeamsModel
import com.example.mwmfootball.retrofit.L1.L1Teams
import com.example.mwmfootball.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class L1TeamsViewModel : ViewModel() {

    var lstL1Teams : MutableLiveData<PLTeamsModel?> = MutableLiveData()

    fun getListL1TeamsDataObserver() : MutableLiveData<PLTeamsModel?> {
        return lstL1Teams
    }
    fun makeL1TeamsCallAPI() {
        val l1TeamsData = RetrofitInstance.getRetrofitInstace().create(L1Teams::class.java)
        val callL1Teams = l1TeamsData.getL1Teams

        callL1Teams.enqueue(object : Callback<PLTeamsModel?> {
            override fun onResponse(call: Call<PLTeamsModel?>, response: Response<PLTeamsModel?>) {
                if (response.isSuccessful) {
                    lstL1Teams.postValue(response.body())
                } else {
                    lstL1Teams.postValue(null)
                }
            }

            override fun onFailure(call: Call<PLTeamsModel?>, t: Throwable) {
                lstL1Teams.postValue(null)
            }
        })
    }

}