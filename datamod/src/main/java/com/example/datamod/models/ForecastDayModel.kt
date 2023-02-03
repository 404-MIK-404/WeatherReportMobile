package com.example.datamod.models

import com.google.gson.annotations.SerializedName

data class ForecastDayModel(

    @SerializedName("date")
    private val date: String?,

    @SerializedName("day")
    private val dayModel: DayModel,


    @SerializedName("hour")
    private val hourModel: List<HourModel>


    ) {
}