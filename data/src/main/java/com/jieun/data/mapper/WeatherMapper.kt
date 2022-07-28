package com.jieun.data.mapper

import com.jieun.data.entity.WeatherEntity
import com.jieun.data.entity.WeatherListEntity
import com.jieun.data.entity.WeatherMainEntity
import com.jieun.data.entity.WeatherWeatherEntity
import com.jieun.data.entity.common.default
import com.jieun.domain.dto.WeatherDto
import com.jieun.domain.dto.WeatherListDto
import com.jieun.domain.dto.WeatherMainDto
import com.jieun.domain.dto.WeatherWeatherDto

object WeatherMapper {
    fun mapperToWeatherEntity(dto: WeatherDto) =
        WeatherEntity(
            code = dto.code,
            message = dto.message,
            cnt = dto.cnt,
            list = mapperToWeatherListEntity(dto.list)
        )

    fun mapperToWeatherDto(entity: WeatherEntity?) =
        WeatherDto(
            code = entity?.code.default(),
            message = entity?.message.default(),
            cnt = entity?.cnt.default(),
            list = mapperToWeatherListDto(entity?.list.default())
        )

    fun mapperToWeatherListEntity(dto: List<WeatherListDto>) =
        dto.map {
            WeatherListEntity(
                dt = it.dt,
                main = mapperToWeatherMainEntity(it.main),
                weather = mapperToWeatherWeatherEntity(it.weather),
                dt_txt = it.dt_txt
            )
        }

    fun mapperToWeatherListDto(entity: List<WeatherListEntity?>) =
        entity.map {
            WeatherListDto(
                dt = it?.dt.default(),
                main = mapperToWeatherMainDto(it?.main),
                weather = mapperToWeatherWeatherDto(it?.weather),
                dt_txt = it?.dt_txt.default()
            )
        }

    fun mapperToWeatherMainEntity(dto: WeatherMainDto) =
        WeatherMainEntity(
            temp = dto.temp,
            feels_like = dto.feels_like,
            temp_min = dto.temp_min,
            temp_max = dto.temp_max,
            pressure = dto.pressure,
            sea_level = dto.sea_level,
            grnd_level = dto.grnd_level,
            humidity = dto.humidity,
            temp_kf = dto.temp_kf
        )

    fun mapperToWeatherMainDto(entity: WeatherMainEntity?) =
        WeatherMainDto(
            temp = entity?.temp.default(),
            feels_like = entity?.feels_like.default(),
            temp_min = entity?.temp_min.default(),
            temp_max = entity?.temp_max.default(),
            pressure = entity?.pressure.default(),
            sea_level = entity?.sea_level.default(),
            grnd_level = entity?.grnd_level.default(),
            humidity = entity?.humidity.default(),
            temp_kf = entity?.temp_kf.default()
        )

    fun mapperToWeatherWeatherEntity(dto: List<WeatherWeatherDto>) =
        dto.map {
            WeatherWeatherEntity(
                id = it.id,
                main = it.main,
                description = it.description,
                icon = it.icon
            )
        }

    fun mapperToWeatherWeatherDto(entity: List<WeatherWeatherEntity>?) = entity?.map {
        WeatherWeatherDto(
            id = it.id.default(),
            main = it.main.default(),
            description = it.description.default(),
            icon = it.icon.default()
        )
    }
        ?: emptyList<WeatherWeatherDto>()
}
