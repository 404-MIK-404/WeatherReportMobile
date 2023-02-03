package com.example.domain

import com.example.datamod.data.repository.WeatherRepository

class GetWeatherCurrentCity(private val weatherRepository: WeatherRepository) {


    fun getWeather(): String{
        return weatherRepository.getWeather()
    }


}