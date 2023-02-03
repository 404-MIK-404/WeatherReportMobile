package com.example.domain.func

import com.example.domain.repository.WeatherRepository

class GetWeatherCurrentCity(private val weatherRepository: WeatherRepository) {


    fun getWeather(): String{
        return weatherRepository.getWeather()
    }


}