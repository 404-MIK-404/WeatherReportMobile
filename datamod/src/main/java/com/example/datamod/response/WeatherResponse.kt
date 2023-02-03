package com.example.datamod.response

import com.example.datamod.list.ForecastDayList
import com.example.datamod.models.CurrentModel
import com.example.datamod.models.LocationModel
import com.google.gson.annotations.SerializedName

data class WeatherResponse(

    @SerializedName("current")
    private val currentModel: CurrentModel,

    @SerializedName("location")
    private val locationModel: LocationModel,

    @SerializedName("forecast")
    private val forecastDayList: ForecastDayList,


    )


{
}