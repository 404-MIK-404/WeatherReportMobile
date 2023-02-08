package com.example.domain.repository


interface WeatherRepository {

    suspend fun findInfoWeatherCity(textCity: String)
    fun getWeather(): String
}