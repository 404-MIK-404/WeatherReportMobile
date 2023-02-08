package com.example.datamod.storage

import com.example.datamod.response.WeatherResponse

interface WeatherStorage {


    fun save(nameCity: WeatherResponse)

    fun getWeather(): String


}