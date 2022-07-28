package com.jieun.data.entity

import com.jieun.data.entity.common.DataEntity

data class GeoEntity(
    val name: String?,
    val lat: Double?,
    val lon: Double?,
    val country: String?
) : DataEntity
