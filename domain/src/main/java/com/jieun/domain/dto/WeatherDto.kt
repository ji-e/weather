package com.jieun.domain.dto

data class WeatherDto(
    val code: String,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherListDto>
)
