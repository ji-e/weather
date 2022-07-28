package com.jieun.data.datasource.geo

import com.jieun.data.entity.GeoEntity

interface GeoDatasource {
    suspend fun getGeoList(q: String): List<GeoEntity>?
}
