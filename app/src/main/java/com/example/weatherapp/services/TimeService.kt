package com.example.weatherapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.util.*

class TimerService : Service() {

    private val timer = Timer()

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val time = intent.getLongExtra(TIME_EXTRA,0L)
        timer.scheduleAtFixedRate(TimeTask(time),0,1000)
        return START_NOT_STICKY
    }


    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }


    private inner class TimeTask(private var time: Long): TimerTask(){
        override fun run() {
            val intent = Intent(TIMER_UPDATED)
            time += 1000
            intent.putExtra(TIME_EXTRA,time)
            sendBroadcast(intent)
        }
    }

    companion object {
        const val TIMER_UPDATED = "timerUpdate"
        const val TIME_EXTRA = "timeExtra"
    }


}