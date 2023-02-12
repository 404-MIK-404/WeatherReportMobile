package com.example.weatherapp

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import com.example.weatherapp.animation.AnimationActivity
import java.util.Date


class LocalTimeTimer {

    private var isChange = false

    fun changeTime(time: Long,textViewTimeLocal: TextView,layout: LinearLayout,context: Context){
        textViewTimeLocal.text = TimeFormatters.TIME.formatter.format(time)
        setThemeDayTimer(TimeFormatters.TIME_HOUR.formatter.format(time).toInt(),
            TimeFormatters.TIME_MINUTE.formatter.format(time).toInt(),layout,context)
    }

    fun setThemeDayTimer(hour: Int,minute: Int, layout: LinearLayout, context: Context){
        if (hour == 7 && !isChange && minute == 0){
            isChange = true
            AnimationActivity.changeColor(layout = layout, context = context,"n->m")
        } else if (hour == 11 && !isChange && minute == 0) {
            isChange = true
            AnimationActivity.changeColor(layout = layout, context = context,"m->d")
        } else if (hour == 17 && !isChange && minute == 0){
            isChange = true
            AnimationActivity.changeColor(layout = layout, context = context,"d->e")
        } else if (hour == 19 && !isChange && minute == 0){
            isChange = true
            AnimationActivity.changeColor(layout = layout, context = context,"e->n")
        }
        if (minute > 0 && isChange){
            isChange = false
        }
    }

    fun setThemeDay(hour: Date,layout: LinearLayout,context: Context){
        var hourValue = TimeFormatters.TIME_HOUR.formatter.format(hour).toInt()
        if (hourValue in 7..11) {
            AnimationActivity.changeColor(layout,context,"m")
        } else if (hourValue in 11..17){
            AnimationActivity.changeColor(layout,context,"d")
        } else if (hourValue in 17..22){
            AnimationActivity.changeColor(layout,context,"e")
        } else if (hourValue > 22 || hourValue < 7){
            AnimationActivity.changeColor(layout,context,"n")
        }
    }



}