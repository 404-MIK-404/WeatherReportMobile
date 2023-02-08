package com.example.datamod.models

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("name")
    val name: String?,

    @SerializedName("localtime")
    val localtime: String?,)