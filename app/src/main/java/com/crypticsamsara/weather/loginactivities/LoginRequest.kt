package com.crypticsamsara.weather.loginactivities

data class LoginRequest(
    val email: String,
    val phoneNumber: String,
    val password: String
) {
    fun isValid(): Boolean =
        email.isNotBlank() && phoneNumber.isNotEmpty() && password.isNotEmpty()

}
