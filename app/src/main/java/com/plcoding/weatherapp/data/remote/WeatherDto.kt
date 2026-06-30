package com.plcoding.weatherapp.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDto(
    @field:Json(name = "elevation")
    val elevation: Double,
    @field:Json(name = "generationtime_ms")
    val generationTimeMs: Double,
    @field:Json(name = "hourly")
    val hourly: Hourly,
    @field:Json(name = "hourly_units")
    val hourlyUnits: HourlyUnits,
    @field:Json(name = "latitude")
    val latitude: Double,
    @field:Json(name = "longitude")
    val longitude: Double,
    @field:Json(name = "timezone")
    val timezone: String,
    @field:Json(name = "timezone_abbreviation")
    val timezoneAbbreviation: String,
    @field:Json(name = "utc_offset_seconds")
    val utcOffsetSeconds: Int
)
