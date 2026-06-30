package com.plcoding.weatherapp.domain.weather

data class WeatherInfo(
    // 7 days data
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    // current hour data
    val currentWeatherData: WeatherData?
)
