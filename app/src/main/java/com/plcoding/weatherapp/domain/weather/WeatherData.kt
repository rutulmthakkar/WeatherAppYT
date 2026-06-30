package com.plcoding.weatherapp.domain.weather

import androidx.compose.runtime.Immutable
import java.time.LocalDateTime

@Immutable
data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Int,
    val weatherType: WeatherType
)
