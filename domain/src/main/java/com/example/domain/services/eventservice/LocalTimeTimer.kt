package com.example.domain.services.eventservice

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import com.example.domain.enums.TimeFormatters
import java.util.Date


class LocalTimeTimer {


    fun changeTime(time: Long, textViewTimeLocal: TextView){
        textViewTimeLocal.text = TimeFormatters.TIME.formatter.format(time)
    }

}