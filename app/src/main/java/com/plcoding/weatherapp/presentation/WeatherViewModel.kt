package com.plcoding.weatherapp.presentation

import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.weatherapp.domain.location.LocationTracker
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
@Stable
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    private val _uiState = mutableStateOf<WeatherUiState>(WeatherUiState.Loading)
    val state: State<WeatherUiState> = _uiState

    fun loadWeatherInfo() {
        viewModelScope.launch {
            _uiState.value = WeatherUiState.Loading

            locationTracker.getCurrentLocation()?.let { location ->
                val result = repository.getWeatherData(location.latitude, location.longitude)

                when (result) {
                    is Resource.Success -> {
                        _uiState.value = WeatherUiState.Success(data = result.data)
                    }
                    is Resource.Error -> {
                        _uiState.value = WeatherUiState.Error(message = result.message ?: "An error occurred!")
                    }
                }
            } ?: kotlin.run {
                _uiState.value = WeatherUiState.Error(
                    message = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                )
            }
        }
    }
}