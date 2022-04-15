package com.example.mwmfootball.retrofit.BL

import com.example.mwmfootball.model.Chart.PLChartModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface BLChart {

    // https://api.football-data.org/v2/competitions/2002/standings?standingType=HOME

    @get:GET("v2/competitions/2002/standings?standingType=HOME")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")

    val callBLChart : Call<PLChartModel>

}