package com.example.datamod.models

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("name")
    private val name: String?,

    @SerializedName("localtime")
    private val localtime: String?,




    ){
}