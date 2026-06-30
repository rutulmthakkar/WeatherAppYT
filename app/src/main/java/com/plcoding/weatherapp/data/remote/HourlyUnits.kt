package com.plcoding.weatherapp.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourlyUnits(
    @field:Json(name = "dew_point_2m")
    val dewPoint2m: String,
    @field:Json(name = "pressure_msl")
    val pressureMsl: String,
    @field:Json(name = "rain")
    val rain: String,
    @field:Json(name = "relative_humidity_2m")
    val relativeHumidity2m: String,
    @field:Json(name = "showers")
    val showers: String,
    @field:Json(name = "snow_depth")
    val snowDepth: String,
    @field:Json(name = "snowfall")
    val snowfall: String,
    @field:Json(name = "surface_pressure")
    val surfacePressure: String,
    @field:Json(name = "temperature_2m")
    val temperature2m: String,
    @field:Json(name = "time")
    val time: String,
    @field:Json(name = "visibility")
    val visibility: String,
    @field:Json(name = "weather_code")
    val weatherCode: String,
    @field:Json(name = "wind_speed_10m")
    val windSpeed10m: String
)
