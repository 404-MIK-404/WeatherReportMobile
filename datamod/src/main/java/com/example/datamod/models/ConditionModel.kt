package com.example.datamod.models

import com.google.gson.annotations.SerializedName

data class ConditionModel(


    @SerializedName("text")
    private val text: String?

) {


    fun getTextCondition(): String? {
        return this.text
    }

}