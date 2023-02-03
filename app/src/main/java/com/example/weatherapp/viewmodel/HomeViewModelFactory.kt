package com.example.weatherapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.datamod.RetroInstance
import com.example.datamod.sharedrefs.SharedPrefWeatherStorage
import com.example.domain.func.FindWeatherCurrentCity
import com.example.domain.func.GetWeatherCurrentCity
import com.example.datamod.repository.WeatherRepositoryImpl
import com.example.datamod.services.RetroServiceInterface

class HomeViewModelFactory(context:Context): ViewModelProvider.Factory {

    private val weatherRepository by lazy(LazyThreadSafetyMode.NONE) { WeatherRepositoryImpl(weatherStorage = SharedPrefWeatherStorage(context = context),
                                                                                             retroServiceInterface = RetroInstance.getRetroInstance().
                                                                                             create(RetroServiceInterface::class.java)) }

    private val getWeatherCurrentCity by lazy(LazyThreadSafetyMode.NONE) { GetWeatherCurrentCity(weatherRepository = weatherRepository) }

    private val findWeatherCurrentCity by lazy(LazyThreadSafetyMode.NONE) { FindWeatherCurrentCity(weatherRepository = weatherRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(getWeatherCurrentCity=getWeatherCurrentCity,
            findWeatherCurrentCity=findWeatherCurrentCity) as T
    }



}