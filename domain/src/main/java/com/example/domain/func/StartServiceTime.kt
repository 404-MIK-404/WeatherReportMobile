package com.example.domain.func

import android.content.Context
import android.content.Intent
import com.example.domain.enums.TimeFormatters
import com.example.domain.services.TimerService

class StartServiceTime {

    fun startServiceTime(context: Context, localtime: String, serviceIntent: Intent){
        serviceIntent.putExtra(TimerService.TIME_EXTRA, TimeFormatters.FULL_TIME_DATE.formatter.parse(localtime)!!.time)
        context.startService(serviceIntent)
    }

}