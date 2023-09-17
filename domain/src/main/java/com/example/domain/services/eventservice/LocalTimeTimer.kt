package com.example.domain.services.eventservice

import android.widget.TextView
import com.example.domain.enums.TimeFormatters


class LocalTimeTimer {


    fun changeTime(time: Long, textViewTimeLocal: TextView){
        textViewTimeLocal.text = TimeFormatters.TIME.formatter.format(time)
    }

}