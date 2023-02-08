package com.example.datamod.list

import com.example.datamod.models.ForecastDayModel
import com.google.gson.annotations.SerializedName

data class ForecastDayList(

    @SerializedName("forecastday")
    val forecastDayModel: List<ForecastDayModel>,

) {
}