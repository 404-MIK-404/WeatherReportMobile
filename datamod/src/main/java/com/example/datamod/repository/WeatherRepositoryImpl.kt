package com.example.datamod.repository

import android.util.Log
import com.example.datamod.services.RetroServiceInterface
import com.example.datamod.storage.WeatherStorage
import com.example.domain.repository.WeatherRepository


class WeatherRepositoryImpl(private val weatherStorage: WeatherStorage,private val retroServiceInterface: RetroServiceInterface) :
    WeatherRepository {



    override suspend fun findInfoWeatherCity(textCity: String){
        var resultRequest = retroServiceInterface.getInfoWeatherCity(textCity)
        weatherStorage.save(resultRequest)
    }

    override fun getWeather(): String {
        return weatherStorage.getWeather()
    }


}