package com.crypticsamsara.weather.api

import com.crypticsamsara.weather.loginactivities.LoginRequest
import com.crypticsamsara.weather.loginactivities.LoginResponse
import com.crypticsamsara.weather.registrationactivities.RegistrationRequest
import com.crypticsamsara.weather.registrationactivities.RegistrationResponse
import com.crypticsamsara.weather.useractivities.UpdateUserRequest
import com.crypticsamsara.weather.useractivities.UserResponse
import com.crypticsamsara.weather.weatheractivities.WeatherByCoordinatesRequest
import com.crypticsamsara.weather.weatheractivities.WeatherByStateRequest
import com.crypticsamsara.weather.weatheractivities.WeatherResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApiService {
  /*  @POST("onboarding/user/register")
    suspend fun registerUser(@Body request: RegistrationRequest):
            Response<RegistrationResponse>

    @POST("onboarding/user/login")
    suspend fun loginUser(@Body request: LoginRequest):
            Response<LoginResponse> */

    // User Endpoints
    @POST("api/users")
    suspend fun registerUser(@Body registerRequest: RegistrationRequest): Response<RegistrationResponse>

    @POST("api/users/auth")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @GET("api/users/me")
    suspend fun getCurrentUser(@Header("Authorization") token: String): Response<UserResponse>

    @PATCH("api/users/updateUser/{id}")
    suspend fun updateUser(
        @Path("id") userId: String,
        @Body updateRequest: UpdateUserRequest,
        @Header("Authorization") token: String
    ): Response<UserResponse>

    // Weather Endpoints
    @POST("api/weather/by-state")
    suspend fun getWeatherByState(
        @Body request: WeatherByStateRequest,
        @Header("Authorization") token: String
    ): Response<WeatherResponse>

    @POST("api/weather/by-coordinates")
    suspend fun getWeatherByCoordinates(
        @Body request: WeatherByCoordinatesRequest,
        @Header("Authorization") token: String
    ): Response<WeatherResponse>


}