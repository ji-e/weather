package com.jieun.data.datasource.weather

import com.jieun.data.api.WeatherService
import com.jieun.data.entity.WeatherEntity
import javax.inject.Inject

class WeatherDatasourceImpl @Inject constructor(private val service: WeatherService) :
    WeatherDatasource {
    override suspend fun getWeatherList(lat: Double, lon: Double): WeatherEntity {
        return service.getWeatherList(lat = lat, lon = lon)
    }
}
