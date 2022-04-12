package com.example.mwmfootball.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    // https://api.football-data.org/v2/competitions/2021

    companion object {
        val BASE_URL : String = "https://api.football-data.org"

        fun getRetrofitInstace() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}