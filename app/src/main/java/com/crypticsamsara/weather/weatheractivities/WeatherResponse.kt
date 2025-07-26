package com.crypticsamsara.weather.weatheractivities

import com.google.gson.annotations.SerializedName

data class WeatherResponse(  @SerializedName("lat") val latitude: Double,
                             @SerializedName("lon") val longitude: Double,
                             @SerializedName("timezone") val timezone: String,
                             @SerializedName("timezone_offset") val timezoneOffset: Int,
                             @SerializedName("current") val current: CurrentWeather,
                             @SerializedName("daily") val daily: List<DailyWeather>
)

data class CurrentWeather(
    @SerializedName("dt") val date: Long,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long,
    @SerializedName("temp") val temperature: Double,
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("dew_point") val dewPoint: Double,
    @SerializedName("uvi") val uvIndex: Double,
    @SerializedName("clouds") val clouds: Int,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("wind_speed") val windSpeed: Double,
    @SerializedName("wind_deg") val windDegree: Int,
    @SerializedName("weather") val weather: List<WeatherDescription>
)

data class DailyWeather(
    @SerializedName("dt") val date: Long,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long,
    @SerializedName("temp") val temperature: Temperature,
    @SerializedName("feels_like") val feelsLike: FeelsLike,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("dew_point") val dewPoint: Double,
    @SerializedName("wind_speed") val windSpeed: Double,
    @SerializedName("wind_deg") val windDegree: Int,
    @SerializedName("weather") val weather: List<WeatherDescription>,
    @SerializedName("clouds") val clouds: Int,
    @SerializedName("pop") val precipitationProbability: Double,
    @SerializedName("rain") val rain: Double?,
    @SerializedName("uvi") val uvIndex: Double
)

data class WeatherDescription(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)

data class Temperature(
    @SerializedName("day") val day: Double,
    @SerializedName("min") val min: Double,
    @SerializedName("max") val max: Double,
    @SerializedName("night") val night: Double,
    @SerializedName("eve") val evening: Double,
    @SerializedName("morn") val morning: Double
)

data class FeelsLike(
    @SerializedName("day") val day: Double,
    @SerializedName("night") val night: Double,
    @SerializedName("eve") val evening: Double,
    @SerializedName("morn") val morning: Double
)
