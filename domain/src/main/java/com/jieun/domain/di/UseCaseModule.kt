package com.jieun.domain.di

import com.jieun.domain.repository.GeoRepository
import com.jieun.domain.repository.WeatherRepository
import com.jieun.domain.usecase.geo.GetGeoListUseCase
import com.jieun.domain.usecase.weather.GetWeatherListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetGeoListUseCase(repository: GeoRepository) =
        GetGeoListUseCase(repository)

    @Provides
    @Singleton
    fun provideGetWeatherListUseCase(repository: WeatherRepository) =
        GetWeatherListUseCase(repository)
}
