package com.crypticsamsara.weather.useractivities

data class UpdateUserRequest(
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val state: String? = null,
    val city: String? = null,
    val lga: String? = null
)