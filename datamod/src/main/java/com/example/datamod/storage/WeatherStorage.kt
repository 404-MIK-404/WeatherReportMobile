package com.example.datamod.storage

interface WeatherStorage {


    fun save(nameCity: String)

    fun getCity(): String


}