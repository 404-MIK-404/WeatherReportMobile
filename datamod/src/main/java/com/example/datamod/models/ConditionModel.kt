package com.example.datamod.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConditionModel(

    @SerializedName("text")
    val text: String?,

) : Parcelable