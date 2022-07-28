package com.jieun.data.di

import com.jieun.data.datasource.geo.GeoDatasource
import com.jieun.data.datasource.weather.WeatherDatasource
import com.jieun.data.repository.GeoRepositoryImpl
import com.jieun.data.repository.WeatherRepositoryImpl
import com.jieun.domain.repository.GeoRepository
import com.jieun.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGeoRepository(
        dataSource: GeoDatasource
    ): GeoRepository =
        GeoRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideWeatherRepository(
        dataSource: WeatherDatasource
    ): WeatherRepository =
        WeatherRepositoryImpl(dataSource)
}
