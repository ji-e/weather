package com.jieun.domain.usecase.geo

import com.jieun.domain.dto.GeoDto
import com.jieun.domain.repository.GeoRepository
import javax.inject.Inject

class GetGeoListUseCase @Inject constructor(
    private val repository: GeoRepository
) {
    suspend operator fun invoke(q: String): List<GeoDto> = repository.getGeoList(q)
}
