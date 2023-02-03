package com.example.datamod.models

import com.google.gson.annotations.SerializedName

data class HourModel(

    @SerializedName("time")
    private val time: String?,

    @SerializedName("temp_c")
    private val temp_c: String?,

    @SerializedName("condition")
    private val conditionModel: ConditionModel) {



}