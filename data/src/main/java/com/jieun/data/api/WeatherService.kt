package com.jieun.data.api

import com.jieun.data.entity.WeatherEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("/data/2.5/forecast")
    suspend fun getWeatherList(
        @Query(LAT) lat: Double,
        @Query(LON) lon: Double,
        @Query(UNITS) units: String = DEFAULT_UNITS,
        @Query(LANG) lang: String = DEFAULT_LANG,
        @Query(APP_ID) appid: String = DEFAULT_APP_ID
    ): WeatherEntity

    companion object {
        const val DEFAULT_UNITS = "metric"
        const val DEFAULT_LANG = "KR"
        const val DEFAULT_APP_ID = "a24043db8d474ea38c5e4979930d944c"
        const val LAT = "lat"
        const val LON = "lon"
        const val UNITS = "units"
        const val LANG = "lang"
        const val APP_ID = "appid"
    }
}
