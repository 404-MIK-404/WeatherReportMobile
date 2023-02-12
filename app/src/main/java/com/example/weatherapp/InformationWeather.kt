package com.example.weatherapp

import android.content.Context
import android.graphics.Color
import app.futured.donut.DonutSection
import com.example.datamod.response.WeatherResponse
import com.example.weatherapp.databinding.ActivityHomeBinding
import com.example.weatherapp.databinding.ActivityWeatherCityBinding
import java.util.Date

class InformationWeather {

    companion object{


        fun setValueWeatherDay(context: Context, binding: ActivityHomeBinding, weatherResponse: WeatherResponse){
            with(binding){
                var localtime = TimeFormatters.FULL_TIME_DATE.formatter.parse(weatherResponse.locationModel.localtime.toString())
                tvIconWeatherCity.setImageResource(AdapterManager.setPictureWeather(weatherResponse.currentModel.condition?.text!!))
                viewNameCity.text = weatherResponse.locationModel.name
                valueTempWeather.text = "${weatherResponse.currentModel.temp_c} °С"
                valueTimeLocalCurrentCity.text = TimeFormatters.TIME.formatter.format(localtime!!)
                valueUV.text = weatherResponse.currentModel.uv
                valueHumidity.text = weatherResponse.currentModel.humidity
            }
            AdapterManager.initListDays(binding.listWeatherDays,context,weatherResponse.forecastDayList.forecastDayModel)
        }



        fun setValueWeatherHour(context: Context, binding: ActivityWeatherCityBinding, weatherResponse: WeatherResponse){
            with(binding){
                val pressure = weatherResponse.currentModel.pressure_mb!!.toFloat() * 0.75f
                val section1 = DonutSection(name = "section_1", color = Color.parseColor("#66a6ff"), amount = pressure / 1000)
                val date = Date()
                tvNameDayFull.text = TimeFormatters.LONG_NAME_MONTH.formatter.format(date)
                tvNameDateDay.text = TimeFormatters.FULL_TIME_DATE_STRING.formatter.format(date)
                valueTempCity.text = weatherResponse.currentModel.temp_c
                tvIconWeatherCityCurrent.setImageResource(AdapterManager.setPictureWeather(weatherResponse.currentModel.condition?.text!!))
                tvNameCity.text = weatherResponse.locationModel.name
                tvNameCondition.text = weatherResponse.currentModel.condition?.text
                valueHumidity.text = "${weatherResponse.currentModel.humidity} %"
                valueTempFellsLike.text = "${weatherResponse.currentModel.feelslike_c} °С"
                valueWindSpeed.text = "${weatherResponse.currentModel.wind_kph} (км/ч)"
                valueGust.text = "${weatherResponse.currentModel.gust_kph} (км/ч)"

                viewDonutRain.cap = 1.2f
                viewDonutRain.gapAngleDegrees = 90f
                viewDonutRain.submitData(listOf(section1))

                valuePressure.text = "%.1f".format(pressure)
            }
            AdapterManager.initListHours(binding.listWeatherHour,context,weatherResponse)
        }




    }

}