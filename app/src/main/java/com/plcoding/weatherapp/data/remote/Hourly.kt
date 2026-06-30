package com.plcoding.weatherapp.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hourly(
    @field:Json(name = "dew_point_2m")
    val dewPoint: List<Double>,
    @field:Json(name = "pressure_msl")
    val pressureMsl: List<Double>,
    @field:Json(name = "rain")
    val rain: List<Double>,
    @field:Json(name = "relative_humidity_2m")
    val relativeHumidity: List<Int>,
    @field:Json(name = "showers")
    val showers: List<Double>,
    @field:Json(name = "snow_depth")
    val snowDepth: List<Double>,
    @field:Json(name = "snowfall")
    val snowfall: List<Double>,
    @field:Json(name = "surface_pressure")
    val surfacePressure: List<Double>,
    @field:Json(name = "temperature_2m")
    val temperatures: List<Double>,
    @field:Json(name = "time")
    val time: List<String>,
    @field:Json(name = "visibility")
    val visibility: List<Double>,
    @field:Json(name = "weather_code")
    val weatherCode: List<Int>,
    @field:Json(name = "wind_speed_10m")
    val windSpeed: List<Double>
)
