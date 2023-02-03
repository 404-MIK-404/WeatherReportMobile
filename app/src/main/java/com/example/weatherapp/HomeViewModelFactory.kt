package com.example.weatherapp

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.datamod.data.storage.sharedrefs.SharedPrefWeatherStorage
import com.example.domain.FindWeatherCurrentCity
import com.example.domain.GetWeatherCurrentCity
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.viewmodel.HomeViewModel

class HomeViewModelFactory(context:Context): ViewModelProvider.Factory {

    private val weatherRepository by lazy(LazyThreadSafetyMode.NONE) { WeatherRepositoryImpl(weatherStorage = SharedPrefWeatherStorage(context = context)) }

    private val getWeatherCurrentCity by lazy(LazyThreadSafetyMode.NONE) { GetWeatherCurrentCity(weatherRepository = weatherRepository) }

    private val findWeatherCurrentCity by lazy(LazyThreadSafetyMode.NONE) { FindWeatherCurrentCity(weatherRepository = weatherRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(getWeatherCurrentCity=getWeatherCurrentCity,
            findWeatherCurrentCity=findWeatherCurrentCity) as T
    }



}