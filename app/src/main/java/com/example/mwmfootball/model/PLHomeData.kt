package com.example.mwmfootball.model

import com.google.gson.annotations.SerializedName

data class PLHomeData(
    @SerializedName("area")
    val area: Area,
    @SerializedName("code")
    val code: String,
    @SerializedName("currentSeason")
    val currentSeason: CurrentSeason,
    @SerializedName("emblemUrl")
    val emblemUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("plan")
    val plan: String,
    @SerializedName("seasons")
    val seasons: List<Season>
)