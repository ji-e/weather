package com.jieun.data.di

import com.jieun.data.api.GeoService
import com.jieun.data.api.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkServiceModule {

    @Provides
    @Singleton
    fun provideGeoService(
        retrofitBuilder: Retrofit
    ): GeoService = retrofitBuilder.create(GeoService::class.java)

    @Provides
    @Singleton
    fun provideWeatherService(
        retrofitBuilder: Retrofit
    ): WeatherService = retrofitBuilder.create(WeatherService::class.java)
}
