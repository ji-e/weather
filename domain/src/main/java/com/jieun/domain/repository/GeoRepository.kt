package com.jieun.domain.repository

import com.jieun.domain.dto.GeoDto

interface GeoRepository {
    suspend fun getGeoList(q: String): List<GeoDto>
}
