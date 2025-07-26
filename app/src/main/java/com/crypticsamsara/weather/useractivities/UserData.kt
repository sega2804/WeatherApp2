package com.crypticsamsara.weather.useractivities

import com.crypticsamsara.weather.weatheractivities.Location
import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("_id") val id: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("email") val email: String?,
    @SerializedName("phoneNumber") val phoneNumber: String?,
    @SerializedName("location") val location: Location?,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("__v") val version: Int
)
