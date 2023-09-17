package com.example.weatherapp.viewmodel

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datamod.response.WeatherResponse
import com.example.domain.func.*
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
                                        private val setDarkMode: SetDarkMode,
                                        private val findInfoAboutDarkMode: FindInfoAboutDarkMode,
                                        private val getWeatherCurrentCity: GetWeatherCurrentCity,
                                        private val findWeatherCurrentCity: FindWeatherCurrentCity,
                                        private val startServiceTime: StartServiceTime,
): ViewModel() {

    private val resultResponseWeather = MutableLiveData<WeatherResponse>()

    private val modeIsDark = MutableLiveData<Boolean>()


    fun getResponseWeather(): LiveData<WeatherResponse> {
        return resultResponseWeather
    }


    fun getModeIsDark(): LiveData<Boolean> {
        return modeIsDark
    }

    fun getModeIsDarkV2() : Boolean? {
        return modeIsDark.value
    }


    init {
        Log.e("Init VM","VM was create")
    }

    fun changeDarkMode(result: Boolean){
        if (result != this.modeIsDark.value){
            setDarkMode.execute(result)
            this.modeIsDark.value = result
        }
    }

    fun findInfoDarkMode(){
        if (this.modeIsDark.value == null){
            this.modeIsDark.value = findInfoAboutDarkMode.execute()
        }
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


    fun startServiceTime(context: Context,weatherResponse: WeatherResponse,serviceIntent: Intent){
        startServiceTime.startServiceTime(context = context, localtime = weatherResponse.locationModel.localtime!!, serviceIntent = serviceIntent)
    }


    override fun onCleared() {
        Log.e("VM action","VM is clear")
        super.onCleared()
    }
}