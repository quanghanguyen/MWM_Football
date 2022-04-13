package com.example.mwmfootball.model.Teams

import com.google.gson.annotations.SerializedName

data class Season(
    @SerializedName("currentMatchday")
    val currentMatchday: Int,
    @SerializedName("endData")
    val endDate: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("winner")
    val winner: Any
)