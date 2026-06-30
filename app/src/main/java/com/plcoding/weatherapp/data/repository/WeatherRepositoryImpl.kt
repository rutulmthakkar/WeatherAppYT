package com.plcoding.weatherapp.data.repository

import com.plcoding.weatherapp.data.remote.WeatherApi
import com.plcoding.weatherapp.di.IoDispatcher
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import com.plcoding.weatherapp.mappers.toWeatherInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    @param:IoDispatcher private val ioDispatcher: CoroutineDispatcher
): WeatherRepository {

    override suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Resource<WeatherInfo> = withContext(ioDispatcher) {
        try {
            Resource.Success(
                data = weatherApi.getWeatherData(latitude, longitude).hourly.toWeatherInfo()
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unknown error occurred!")
        }
    }
}