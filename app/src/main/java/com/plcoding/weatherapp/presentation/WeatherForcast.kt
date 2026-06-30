package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.weatherapp.domain.weather.WeatherData

@Composable
fun WeatherForecast(
    weatherForecastData: Map<Int, List<WeatherData>>,
    modifier: Modifier = Modifier
) {
    weatherForecastData[0]?.let { todayWeatherData ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Today",
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(Modifier.height(16.dp))
            LazyRow(
                modifier = modifier
            ) {
                items(todayWeatherData) { weatherData ->
                    HourlyWeatherDisplay(
                        data = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp),
                        textColor = Color.White
                    )
                }
            }
        }
    }
}