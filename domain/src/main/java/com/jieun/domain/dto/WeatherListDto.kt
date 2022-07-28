package com.jieun.domain.dto

data class WeatherListDto(
    val dt: Long,
    val main: WeatherMainDto,
    val weather: List<WeatherWeatherDto>,
    val dt_txt: String
)
