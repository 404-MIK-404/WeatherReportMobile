package com.example.weatherapp.data.repository

import com.example.datamod.data.repository.WeatherRepository
import com.example.datamod.data.storage.WeatherStorage


class WeatherRepositoryImpl(private val weatherStorage: com.example.datamod.data.storage.WeatherStorage) :
    com.example.datamod.data.repository.WeatherRepository {


    override fun findInfoWeatherCity(textCity: String){
        weatherStorage.save(textCity)
    }

    override fun getWeather(): String {
        return weatherStorage.getCity()
    }


}