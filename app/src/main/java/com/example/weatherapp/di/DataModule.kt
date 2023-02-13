package com.example.weatherapp.di

import android.content.Context
import com.example.datamod.RetroInstance
import com.example.datamod.repository.WeatherRepositoryImpl
import com.example.datamod.services.RetroServiceInterface
import com.example.datamod.sharedrefs.SharedPrefWeatherStorage
import com.example.datamod.storage.WeatherStorage
import com.example.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): WeatherStorage {
        return SharedPrefWeatherStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideRetroInstance(): RetroServiceInterface {
        return RetroInstance.getRetroInstance().create(RetroServiceInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherStorage: WeatherStorage,retroInstance: RetroServiceInterface): WeatherRepository {
        return WeatherRepositoryImpl(weatherStorage = weatherStorage, retroServiceInterface = retroInstance)
    }

}