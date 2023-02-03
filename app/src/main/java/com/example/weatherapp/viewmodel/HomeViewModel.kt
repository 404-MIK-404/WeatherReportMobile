package com.example.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.func.FindWeatherCurrentCity
import com.example.domain.func.GetWeatherCurrentCity
import com.example.weatherapp.WeatherCity

class HomeViewModel(private val getWeatherCurrentCity: GetWeatherCurrentCity,
                    private val findWeatherCurrentCity: FindWeatherCurrentCity
): ViewModel() {


    private val resultCityName = MutableLiveData<String>()


    fun getCityLive(): LiveData<String> {
        return resultCityName
    }

    init {
        Log.e("Test","VM create")
    }

    override fun onCleared() {
        Log.e("Test","VM clear")
        super.onCleared()
    }


    fun saveCity(cityEnter: String) {
        findWeatherCurrentCity.execute(cityEnter)
    }

    fun getCity(){
        resultCityName.value = getWeatherCurrentCity.getWeather()
    }

}