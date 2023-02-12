package com.example.datamod.list

import android.os.Parcelable
import com.example.datamod.models.ForecastDayModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastDayList(

    @SerializedName("forecastday")
    val forecastDayModel: List<ForecastDayModel>,

) : Parcelable {
}