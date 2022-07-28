package com.jieun.weather.main

import com.jieun.domain.dto.WeatherMainDto
import com.jieun.domain.dto.WeatherWeatherDto

sealed class MainWeatherItem {
    data class City(val city: String) : MainWeatherItem()
    data class Weather(
        val dt: Long,
        val main: WeatherMainDto,
        val weather: List<WeatherWeatherDto>,
        val dt_txt: String
    ) : MainWeatherItem()
}
