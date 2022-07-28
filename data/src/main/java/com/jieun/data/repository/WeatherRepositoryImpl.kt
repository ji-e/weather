package com.jieun.data.repository

import com.jieun.data.datasource.weather.WeatherDatasource
import com.jieun.data.mapper.WeatherMapper.mapperToWeatherDto
import com.jieun.domain.dto.WeatherDto
import com.jieun.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val dataSource: WeatherDatasource) :
    WeatherRepository {
    override suspend fun getWeatherList(lat: Double, lon: Double): WeatherDto {
        val response = dataSource.getWeatherList(lat, lon)
        return mapperToWeatherDto(response)
    }
}
