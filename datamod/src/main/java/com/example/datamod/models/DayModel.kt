package com.example.datamod.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DayModel(

    @SerializedName("avgtemp_c")
    val avgtemp_c: String,

    @SerializedName("condition")
    val conditionModel: ConditionModel,

) : Parcelable