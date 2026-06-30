package com.plcoding.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/v1/forecast?hourly=temperature_2m,relative_humidity_2m,dew_point_2m,weather_code,wind_speed_10m,rain,showers,snowfall,snow_depth,pressure_msl,surface_pressure,visibility")
    suspend fun getWeatherData(
        @Query(LATITUDE_PARAM) lat: Double,
        @Query(LONGITUDE_PARAM) long: Double
    ): WeatherDto

    companion object {
        const val BASE_URL = "https://api.open-meteo.com/"
        const val LATITUDE_PARAM = "latitude"
        const val LONGITUDE_PARAM = "longitude"
    }
}