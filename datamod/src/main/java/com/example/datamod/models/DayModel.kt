package com.example.datamod.models

import com.google.gson.annotations.SerializedName

data class DayModel(

    @SerializedName("avgtemp_c")
    private val avgtemp_c: String?,

    @SerializedName("condition")
    private val conditionModel: ConditionModel,

) {
}