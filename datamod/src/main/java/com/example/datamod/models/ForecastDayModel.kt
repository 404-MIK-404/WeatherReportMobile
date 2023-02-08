package com.example.datamod.models

import com.google.gson.annotations.SerializedName

data class ForecastDayModel(

    @SerializedName("date")
    val date: String?,

    @SerializedName("day")
    val dayModel: DayModel,

    @SerializedName("hour")
    val hourModel: List<HourModel>)