package com.example.mwmfootball.retrofit.PL

import com.example.mwmfootball.model.PLHomeData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface PLHome {

    // https://api.football-data.org/v2/competitions/2021

    @get:GET("v2/competitions/2021")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")

    val plHomeData : Call<PLHomeData>

}