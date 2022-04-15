package com.example.mwmfootball.retrofit.SA

import com.example.mwmfootball.model.Teams.PLTeamsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface SATeams {

    // https://api.football-data.org/v2/competitions/2019/teams

    @get:GET("v2/competitions/2019/teams")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")

    val callBLTeams : Call<PLTeamsModel>

}