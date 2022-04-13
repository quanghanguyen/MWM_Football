package com.example.mwmfootball.model.Teams

import com.google.gson.annotations.SerializedName

data class PLTeamsModel(
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("count")
    val count: Int,
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("season")
    val season: Season,
    @SerializedName("teams")
    val teams: List<Team>
)