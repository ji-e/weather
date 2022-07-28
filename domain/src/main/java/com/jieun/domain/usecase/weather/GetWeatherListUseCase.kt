package com.jieun.domain.usecase.weather

import com.jieun.domain.dto.WeatherDto
import com.jieun.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherListUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(lat: Double, lon: Double): WeatherDto =
        repository.getWeatherList(lat, lon)
}
