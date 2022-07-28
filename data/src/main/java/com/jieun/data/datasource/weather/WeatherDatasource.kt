package com.jieun.data.datasource.weather

import com.jieun.data.entity.WeatherEntity

interface WeatherDatasource {
    suspend fun getWeatherList(lat: Double, lon: Double): WeatherEntity?
}
