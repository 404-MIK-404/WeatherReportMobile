package com.example.datamod


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object{

        val BASE_URL = "https://api.weatherapi.com/v1/"

        fun getRetroInstance(): Retrofit {
            return Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }


}