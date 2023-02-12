package com.example.datamod.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentModel(

    @SerializedName("temp_c")
    val temp_c:String?,

    @SerializedName("is_day")
    val is_day:String?,

    @SerializedName("condition")
    val condition:ConditionModel?,

    @SerializedName("wind_kph")
    val wind_kph:String?,

    @SerializedName("pressure_mb")
    val pressure_mb: String?,

    @SerializedName("humidity")
    val humidity: String?,

    @SerializedName("feelslike_c")
    val feelslike_c: String?,

    @SerializedName("uv")
    val uv: String?,

    @SerializedName("gust_kph")
    val gust_kph: String?,

) : Parcelable
