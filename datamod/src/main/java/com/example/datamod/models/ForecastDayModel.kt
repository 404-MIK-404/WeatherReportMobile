package com.example.datamod.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastDayModel(

    @SerializedName("date")
    val date: String?,

    @SerializedName("day")
    val dayModel: DayModel,

    @SerializedName("hour")
    val hourModel: List<HourModel>) : Parcelable