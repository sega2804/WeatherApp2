package com.crypticsamsara.weather.useractivities

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: UserData
)