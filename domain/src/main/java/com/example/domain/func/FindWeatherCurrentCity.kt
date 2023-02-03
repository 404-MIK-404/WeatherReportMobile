package com.example.domain.func

import com.example.domain.repository.WeatherRepository


class FindWeatherCurrentCity(private val weatherRepository: WeatherRepository) {

    fun execute(cityEnter: String){
        weatherRepository.findInfoWeatherCity(cityEnter)
    }

}