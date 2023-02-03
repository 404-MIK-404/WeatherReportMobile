package com.example.datamod.data.repository


interface WeatherRepository {

    fun findInfoWeatherCity(textCity: String)
    fun getWeather(): String
}