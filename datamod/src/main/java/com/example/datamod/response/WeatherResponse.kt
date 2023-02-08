package com.example.datamod.response

import com.example.datamod.list.ForecastDayList
import com.example.datamod.models.CurrentModel
import com.example.datamod.models.LocationModel
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("current")
    val currentModel: CurrentModel,

    @SerializedName("location")
    val locationModel: LocationModel,

    @SerializedName("forecast")
    val forecastDayList: ForecastDayList)
