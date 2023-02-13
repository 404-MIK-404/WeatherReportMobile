package com.example.domain.enums

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
enum class TimeFormatters(val formatter: SimpleDateFormat) {

    FULL_TIME_DATE(SimpleDateFormat("yyyy-MM-dd hh:mm")),
    TIME(SimpleDateFormat("HH:mm")),
    DATE(SimpleDateFormat("yyyy-MM-dd")),
    TIME_HOUR(SimpleDateFormat("HH")),
    TIME_MINUTE(SimpleDateFormat("mm")),
    SHORT_NAME_MONTH(SimpleDateFormat("EE", Locale.ENGLISH)),
    LONG_NAME_MONTH(SimpleDateFormat("EEEE", Locale.ENGLISH)),
    FULL_TIME_DATE_STRING(SimpleDateFormat("d MMM yyyy")),

}