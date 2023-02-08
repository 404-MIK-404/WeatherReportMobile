package com.example.datamod.models

import com.google.gson.annotations.SerializedName

data class DayModel(

    @SerializedName("avgtemp_c")
    val avgtemp_c: String,

    @SerializedName("condition")
    val conditionModel: ConditionModel,

)