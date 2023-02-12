package com.example.datamod.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HourModel(

    @SerializedName("time")
    val time: String?,

    @SerializedName("temp_c")
    val temp_c: String?,

    @SerializedName("condition")
    val conditionModel: ConditionModel) : Parcelable