package com.example.weatherapp.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datamod.response.WeatherResponse
import com.example.domain.func.FindWeatherCurrentCity
import com.example.domain.func.GetWeatherCurrentCity
import com.google.gson.Gson
import kotlinx.coroutines.*

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


    fun findInfoAboutWeather(cityEnter: String,context: Context) {
        viewModelScope.launch {
            try {
                findWeatherCurrentCity.execute(cityEnter = cityEnter)
            } catch (ex: java.lang.RuntimeException) {
                Toast.makeText(context,"Произошла ошибка при попытке найти информацию о погоде данного города ",Toast.LENGTH_SHORT).show()
            } finally {
                findResponseWeather(context)
            }
        }
    }

    fun findResponseWeather(context: Context){
        try {
            var res = getWeatherCurrentCity.getWeather()
            resultResponseWeather.value = Gson().fromJson(res,WeatherResponse::class.java)
        } catch (ex: java.lang.RuntimeException){
            Toast.makeText(context,"Произошла ошибка при загрузке погоды города",Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCleared() {
        Log.e("Test","VM clear")
        super.onCleared()
    }
}