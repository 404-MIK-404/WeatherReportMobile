package com.example.datamod.sharedrefs

import android.content.Context
import com.example.datamod.storage.WeatherStorage


private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val DEFAULT_NAME = "London"


class SharedPrefWeatherStorage(context: Context) : WeatherStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)


    override fun save(nameCity: String) {
        sharedPreferences.edit().putString(KEY_FIRST_NAME,nameCity).apply()
    }

    override fun getCity(): String {
        var nameCity = sharedPreferences.getString(KEY_FIRST_NAME,"London") ?: DEFAULT_NAME
        return nameCity
    }


}