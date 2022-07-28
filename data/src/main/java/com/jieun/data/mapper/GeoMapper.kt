package com.jieun.data.mapper

import com.jieun.data.entity.GeoEntity
import com.jieun.data.entity.common.default
import com.jieun.domain.dto.GeoDto

object GeoMapper {
    fun mapperToGeoEntity(dto: List<GeoDto>) = dto.map {
        GeoEntity(
            name = it.name,
            lat = it.lat,
            lon = it.lon,
            country = it.country
        )
    }

    fun List<GeoEntity?>.mapperToGeoDto() =
        this.map {
            GeoDto(
                name = it?.name.default(),
                lat = it?.lat.default(),
                lon = it?.lon.default(),
                country = it?.country.default()
            )
        }
}
