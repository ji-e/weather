package com.jieun.data.api

import com.jieun.data.entity.GeoEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoService {

    @GET("/geo/1.0/direct")
    suspend fun getGeoList(
        @Query(Q) q: String,
        @Query(LIMIT) limit: Int = DEFAULT_SIZE,
        @Query(APP_ID) appid: String = DEFAULT_APP_ID
    ): List<GeoEntity>?

    companion object {
        const val DEFAULT_SIZE = 5
        const val DEFAULT_APP_ID = "a24043db8d474ea38c5e4979930d944c"
        const val Q = "q"
        const val LIMIT = "limit"
        const val APP_ID = "appid"
    }
}
