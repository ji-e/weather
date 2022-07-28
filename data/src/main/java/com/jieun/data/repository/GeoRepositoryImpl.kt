package com.jieun.data.repository

import com.jieun.data.datasource.geo.GeoDatasource
import com.jieun.data.mapper.GeoMapper.mapperToGeoDto
import com.jieun.domain.dto.GeoDto
import com.jieun.domain.repository.GeoRepository
import javax.inject.Inject

class GeoRepositoryImpl @Inject constructor(private val dataSource: GeoDatasource) : GeoRepository {
    override suspend fun getGeoList(q: String): List<GeoDto> {
        val response = dataSource.getGeoList(q)
        return response?.mapperToGeoDto() ?: emptyList()
    }
}
