package com.jieun.data.di

import com.jieun.data.api.GeoService
import com.jieun.data.api.WeatherService
import com.jieun.data.datasource.geo.GeoDatasource
import com.jieun.data.datasource.geo.GeoDatasourceImpl
import com.jieun.data.datasource.weather.WeatherDatasource
import com.jieun.data.datasource.weather.WeatherDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideGeoRemoteDataSource(
        service: GeoService
    ): GeoDatasource =
        GeoDatasourceImpl(service)

    @Singleton
    @Provides
    fun provideWeatherRemoteDataSource(
        service: WeatherService
    ): WeatherDatasource =
        WeatherDatasourceImpl(service)
}
