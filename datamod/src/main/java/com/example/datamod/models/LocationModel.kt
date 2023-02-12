package com.example.datamod.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationModel(

    @SerializedName("name")
    val name: String?,

    @SerializedName("localtime")
    val localtime: String?,

    @SerializedName("tz_id")
    val timeZoneId: String?
    ) : Parcelable
