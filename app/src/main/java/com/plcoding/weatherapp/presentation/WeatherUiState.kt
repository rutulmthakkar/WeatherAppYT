package com.plcoding.weatherapp.presentation

import com.plcoding.weatherapp.domain.weather.WeatherInfo

sealed class WeatherUiState {
    object Loading : WeatherUiState()
    data class Success(val data: WeatherInfo?) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}
