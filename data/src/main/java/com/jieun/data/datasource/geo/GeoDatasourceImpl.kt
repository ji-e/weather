package com.jieun.data.datasource.geo

import com.jieun.data.api.GeoService
import com.jieun.data.entity.GeoEntity
import javax.inject.Inject

class GeoDatasourceImpl @Inject constructor(private val service: GeoService) : GeoDatasource {
    override suspend fun getGeoList(q: String): List<GeoEntity>? {
        return service.getGeoList(q = q)
    }
}
