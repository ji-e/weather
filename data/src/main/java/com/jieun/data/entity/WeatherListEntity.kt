package com.jieun.data.entity

import com.jieun.data.entity.common.DataEntity

data class WeatherListEntity(
    val dt: Long?,
    val main: WeatherMainEntity?,
    val weather: List<WeatherWeatherEntity>?,
    val dt_txt: String?
) : DataEntity
