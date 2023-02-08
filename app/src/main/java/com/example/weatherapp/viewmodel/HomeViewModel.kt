package com.example.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datamod.RetroInstance
import com.example.datamod.response.WeatherResponse
import com.example.datamod.services.RetroServiceInterface
import com.example.domain.func.FindWeatherCurrentCity
import com.example.domain.func.GetWeatherCurrentCity
import com.google.gson.Gson
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(private val getWeatherCurrentCity: GetWeatherCurrentCity,
                    private val findWeatherCurrentCity: FindWeatherCurrentCity
): ViewModel() {


    private val resultResponseWeather = MutableLiveData<WeatherResponse>()


    fun getResponseWeather(): LiveData<WeatherResponse> {
        return resultResponseWeather
    }

    init {
        Log.e("Test","VM create")
    }


    fun findInfoAboutWeather(cityEnter: String) {
        viewModelScope.launch {
            findWeatherCurrentCity.execute(cityEnter = cityEnter)
            findResponseWeather()
        }
    }

    fun findResponseWeather(){
        var res = getWeatherCurrentCity.getWeather()
        resultResponseWeather.value = Gson().fromJson(res,WeatherResponse::class.java)
    }


    override fun onCleared() {
        Log.e("Test","VM clear")
        super.onCleared()
    }
}