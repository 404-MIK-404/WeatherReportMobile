package com.example.datamod.repository

import android.util.Log
import com.example.datamod.response.WeatherResponse
import com.example.datamod.services.RetroServiceInterface
import com.example.datamod.storage.WeatherStorage
import com.example.domain.repository.WeatherRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherRepositoryImpl(private val weatherStorage: WeatherStorage,private val retroServiceInterface: RetroServiceInterface) :
    WeatherRepository {


    override fun findInfoWeatherCity(textCity: String){
        retroServiceInterface.getInfoWeatherCity(textCity).enqueue(object :
            Callback<WeatherResponse>{

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                var res = response.body()
                Log.e("RES-WEATH",res.toString())
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("INFO-WEATH",t.toString())
            }

        })
        //weatherStorage.save(textCity)
    }

    override fun getWeather(): String {
        return weatherStorage.getCity()
    }


}