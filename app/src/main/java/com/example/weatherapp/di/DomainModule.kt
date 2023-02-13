package com.example.weatherapp.di

import com.example.domain.func.*
import com.example.domain.repository.WeatherRepository
import com.example.domain.services.eventservice.LocalTimeTimer
import com.example.domain.services.TimerService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetWeatherCurrentCity(weatherRepository: WeatherRepository) : GetWeatherCurrentCity{
        return GetWeatherCurrentCity(weatherRepository = weatherRepository)
    }

    @Provides
    fun provideFindWeatherCurrentCity(weatherRepository: WeatherRepository) : FindWeatherCurrentCity{
        return FindWeatherCurrentCity(weatherRepository = weatherRepository)
    }

    @Provides
    fun provideSetThemeForBackground(localTimeTimer: LocalTimeTimer) : SetThemeForBackground {
        return SetThemeForBackground(localTimeTimer = localTimeTimer)
    }

    @Provides
    fun provideLocalTimeTimer(): LocalTimeTimer {
        return LocalTimeTimer()
    }

    @Provides
    fun provideInitAnimationBackground() : InitAnimationBackground {
        return InitAnimationBackground()
    }

    @Provides
    @Singleton
    fun provideTimerService() : TimerService {
        return TimerService()
    }

    @Provides
    fun provideStartServiceTime() : StartServiceTime {
        return StartServiceTime()
    }



}