package com.example.domain.func

import android.content.Context
import android.widget.LinearLayout
import com.example.domain.enums.TimeFormatters
import com.example.domain.services.eventservice.LocalTimeTimer

class SetThemeForBackground(private val localTimeTimer: LocalTimeTimer) {

    fun setThemeBackground(localtime: String, linear: LinearLayout,context: Context){
        localTimeTimer.setThemeDay(TimeFormatters.FULL_TIME_DATE.formatter.parse(localtime)!!,linear,context)
    }

}