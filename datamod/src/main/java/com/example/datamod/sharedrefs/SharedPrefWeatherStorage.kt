package com.example.datamod.sharedrefs

import android.content.Context
import com.example.datamod.response.WeatherResponse
import com.example.datamod.storage.WeatherStorage
import com.google.gson.Gson


private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "Response Weather"
private const val DEFAULT_NAME = "NG"


class SharedPrefWeatherStorage(context: Context) : WeatherStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)


    override fun save(nameCity: WeatherResponse) {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, Gson().toJson(nameCity)).apply()
    }

    override fun getWeather(): String {
        return sharedPreferences.getString(KEY_FIRST_NAME,"") ?: DEFAULT_NAME
    }


}