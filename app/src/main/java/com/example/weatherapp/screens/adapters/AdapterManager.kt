package com.example.weatherapp.screens.adapters

import android.content.Context
import android.graphics.Rect
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datamod.models.ForecastDayModel
import com.example.datamod.response.WeatherResponse
import com.example.domain.enums.CodeIconWeather
import com.example.domain.enums.TimeFormatters
import com.example.weatherapp.WeatherDay
import com.example.weatherapp.data.WeatherHours
import java.util.*


class AdapterManager {



    companion object {

        private val adapterHours = WeatherHoursAdapter()

        private val adapterDays = WeatherDaysAdapter()



        fun initListDays(listWeatherHour: RecyclerView,context: Context,forecastDayList: List<ForecastDayModel>){
            listWeatherHour.layoutManager = GridLayoutManager(context,3)
            listWeatherHour.adapter = adapterDays
            adapterDays.clearAllData()
            for (item in forecastDayList){
                val date = TimeFormatters.DATE.formatter.parse(item.date.toString())
                adapterDays.addWeatherDay(
                    WeatherDay(
                        CodeIconWeather.setPictureWeather(item.dayModel.conditionModel.text!!),
                        TimeFormatters.SHORT_NAME_MONTH.formatter.format(date.time),
                        item.dayModel.avgtemp_c)
                )
            }

        }

        fun initListHours(listWeatherHour: RecyclerView, context: Context, weatherResponse: WeatherResponse){
            listWeatherHour.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            listWeatherHour.adapter = adapterHours
            TimeFormatters.DATE.formatter.timeZone = TimeZone.getTimeZone(weatherResponse.locationModel.timeZoneId)
            var time = TimeFormatters.DATE.formatter.format(Date())
            adapterHours.clearAllData()
            for (item in weatherResponse.forecastDayList.forecastDayModel){
                if (time.equals(item.date)){
                    for (item1 in item.hourModel){
                        val date1 = TimeFormatters.FULL_TIME_DATE.formatter.parse(item1.time.toString())
                        adapterHours.addWeatherHours(WeatherHours(
                            CodeIconWeather.setPictureWeather(item1.conditionModel.text!!),
                            TimeFormatters.TIME.formatter.format(date1),
                            item1.temp_c.toString()))
                    }
                }
            }

        }





    }

}