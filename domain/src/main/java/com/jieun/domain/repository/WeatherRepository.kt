package com.jieun.domain.repository

import com.jieun.domain.dto.WeatherDto

interface WeatherRepository {
    suspend fun getWeatherList(lat: Double, lon: Double): WeatherDto
}
