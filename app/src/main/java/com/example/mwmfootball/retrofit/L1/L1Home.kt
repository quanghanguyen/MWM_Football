package com.example.mwmfootball.retrofit.L1

import com.example.mwmfootball.model.PLHomeData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface L1Home {

    // https://api.football-data.org/v2/competitions/2015

    @get:GET("v2/competitions/2015")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")

    val getL1Home : Call<PLHomeData>

}