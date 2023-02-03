package com.example.datamod.services

import com.example.datamod.response.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "d9e157222b124c30967134020230102"

interface RetroServiceInterface {

    @GET("forecast.json?key=$API_KEY&q=&days=5")
    fun getInfoWeatherCity(@Query("q")city: String): Call<WeatherResponse>

}