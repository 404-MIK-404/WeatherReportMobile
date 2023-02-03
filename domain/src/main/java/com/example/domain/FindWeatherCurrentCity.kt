package com.example.domain

import com.example.datamod.data.repository.WeatherRepository


class FindWeatherCurrentCity(private val weatherRepository: com.example.datamod.data.repository.WeatherRepository) {

    fun execute(cityEnter: String){
        weatherRepository.findInfoWeatherCity(cityEnter)
    }

}