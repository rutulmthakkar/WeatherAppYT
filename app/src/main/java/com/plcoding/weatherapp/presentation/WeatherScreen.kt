package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel
) {
    val state = viewModel.state
    when (state.value) {
        is WeatherUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is WeatherUiState.Success -> {
            val weatherData = state.value as WeatherUiState.Success
            weatherData.data?.let { data ->
                data.currentWeatherData?.let {
                    WeatherCard(data.currentWeatherData, Color.Blue, Modifier.fillMaxWidth())
                    Spacer(Modifier.height(16.dp))
                    WeatherForecast(data.weatherDataPerDay)
                }
            }
        }

        else -> {
            val errorMessage = (state.value as WeatherUiState.Error).message
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = errorMessage,
                    fontSize = 20.sp,
                    color = Color.Red
                )
            }
        }
    }
}