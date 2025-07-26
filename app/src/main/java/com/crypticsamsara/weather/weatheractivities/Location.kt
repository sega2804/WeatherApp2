package com.crypticsamsara.weather.weatheractivities

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("state") val state: String,
    @SerializedName("city") val city: String?,
    @SerializedName("lga") val lga: String?,
    @SerializedName("address") val address: String?
)
