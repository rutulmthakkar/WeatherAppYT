package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.weatherapp.domain.util.Constants
import com.plcoding.weatherapp.domain.weather.WeatherData

@Composable
fun HourlyWeatherDisplay(
    data: WeatherData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    val time = remember(data.time) {
        data.time.format(Constants.timeFormatter)
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = time,
            color = Color.LightGray
        )
        Image(
            painter = painterResource(id = data.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )
        Text(
            text = "${data.temperatureCelsius} °C",
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}