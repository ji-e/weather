package com.jieun.data.entity

import com.jieun.data.entity.common.DataEntity

data class WeatherEntity(
    val code: String?,
    val message: Int?,
    val cnt: Int?,
    val list: List<WeatherListEntity>?
) : DataEntity
