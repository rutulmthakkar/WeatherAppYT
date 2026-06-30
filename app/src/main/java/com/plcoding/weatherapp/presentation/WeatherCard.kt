package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.weatherapp.R
import com.plcoding.weatherapp.domain.util.Constants
import com.plcoding.weatherapp.domain.weather.WeatherData
import java.time.format.DateTimeFormatter

@Composable
fun WeatherCard(
    weatherData: WeatherData,
    backgroundColor: Color,
    modifier: Modifier
) {
    val time = remember(weatherData.time) {
        weatherData.time.format(Constants.timeFormatter)
    }

    Card(
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Today $time",
                modifier = Modifier.align(Alignment.End),
                color = Color.White
            )
            Spacer(Modifier.height(16.dp))
            Image(
                painter = painterResource(weatherData.weatherType.iconRes),
                contentDescription = weatherData.weatherType.weatherDesc,
                modifier = Modifier.width(200.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "${weatherData.temperatureCelsius} °C",
                fontSize = 50.sp,
                color = Color.White,
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = weatherData.weatherType.weatherDesc,
                fontSize = 20.sp,
                color = Color.White,
            )
            Spacer(Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                WeatherDataDisplay(
                    value = weatherData.pressure.toInt(),
                    unit = "hpa",
                    icon = ImageVector.vectorResource(R.drawable.ic_pressure),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )

                WeatherDataDisplay(
                    value = weatherData.humidity,
                    unit = "%",
                    icon = ImageVector.vectorResource(R.drawable.ic_drop),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )

                WeatherDataDisplay(
                    value = weatherData.windSpeed.toInt(),
                    unit = "km/h",
                    icon = ImageVector.vectorResource(R.drawable.ic_wind),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )
            }
        }
    }
}