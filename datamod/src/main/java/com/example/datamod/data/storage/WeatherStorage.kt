package com.example.datamod.data.storage

interface WeatherStorage {


    fun save(nameCity: String)

    fun getCity(): String


}