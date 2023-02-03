package com.example.datamod.models

import com.google.gson.annotations.SerializedName

data class CurrentModel(

    @SerializedName("temp_c")
    val temp_c:String?,

    @SerializedName("is_day")
    val is_day:String?,

    @SerializedName("condition")
    val condition:ConditionModel?,

    @SerializedName("wind_dir")
    val wind_dir:String?,

    @SerializedName("pressure_mb")
    val pressure_mb: String?,

    @SerializedName("humidity")
    val humidity: String?,

    @SerializedName("feelslike_c")
    val feelslike_c: String?,

    @SerializedName("uv")
    val uv: String?,

)
