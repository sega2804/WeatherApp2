package com.crypticsamsara.weather.loginactivities

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: AuthData?
)

data class AuthData(
    @SerializedName("token") val token: String
)
