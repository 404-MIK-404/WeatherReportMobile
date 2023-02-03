package com.example.domain.repository


interface WeatherRepository {

    fun findInfoWeatherCity(textCity: String)
    fun getWeather(): String
}