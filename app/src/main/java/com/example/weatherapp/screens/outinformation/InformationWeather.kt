package com.example.weatherapp.screens.outinformation

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.futured.donut.DonutSection
import com.example.datamod.response.WeatherResponse
import com.example.domain.enums.CodeIconWeather
import com.example.domain.enums.TimeFormatters
import com.example.weatherapp.screens.adapters.AdapterManager
import com.example.weatherapp.databinding.FragmentDetailWeatherBinding
import com.example.weatherapp.databinding.FragmentHomeBinding
import java.util.Date

class InformationWeather {

    companion object{


        fun setValueWeatherDay(context: Context, binding: FragmentHomeBinding, weatherResponse: WeatherResponse){
            with(binding){
                var localtime = TimeFormatters.FULL_TIME_DATE.formatter.parse(weatherResponse.locationModel.localtime.toString())
                tvIconWeatherCity.setImageResource(CodeIconWeather.setPictureWeather(weatherResponse.currentModel.condition?.text!!))
                viewNameCity.text = weatherResponse.locationModel.name
                valueTempWeather.text = "${weatherResponse.currentModel.temp_c} °С"
                valueTimeLocalCurrentCity.text = TimeFormatters.TIME.formatter.format(localtime!!)
                valueUV.text = weatherResponse.currentModel.uv
                valueHumidity.text = weatherResponse.currentModel.humidity
                textEmptyViewWeatherDaysList.visibility = View.GONE
                listWeatherDays.visibility = View.VISIBLE
                AdapterManager.initListDays(binding.listWeatherDays,context,weatherResponse.forecastDayList.forecastDayModel)
            }
        }



        fun setValueWeatherHour(context: Context, binding: FragmentDetailWeatherBinding, weatherResponse: WeatherResponse){
            with(binding){
                    val pressure = weatherResponse.currentModel.pressure_mb!!.toFloat() * 0.75f
                    val section1 = DonutSection(name = "section_1", color = Color.parseColor("#66a6ff"), amount = pressure / 1000)
                    val date = Date()
                    tvNameDayFull.text = TimeFormatters.LONG_NAME_MONTH.formatter.format(date)
                    tvNameDateDay.text = TimeFormatters.FULL_TIME_DATE_STRING.formatter.format(date)
                    valueTempCity.text = weatherResponse.currentModel.temp_c
                    tvIconWeatherCityCurrent.setImageResource(CodeIconWeather.setPictureWeather(weatherResponse.currentModel.condition?.text!!))
                    tvNameCity.text = weatherResponse.locationModel.name
                    tvNameCondition.text = weatherResponse.currentModel.condition?.text
                    valueHumidity.text = "${weatherResponse.currentModel.humidity} %"
                    valueTempFellsLike.text = "${weatherResponse.currentModel.feelslike_c} °С"
                    valueWindSpeed.text = "${weatherResponse.currentModel.wind_kph} (км/ч)"
                    valueGust.text = "${weatherResponse.currentModel.gust_kph} (км/ч)"
                    viewDonutRain.submitData(listOf(section1))

                    valuePressure.text = "%.1f".format(pressure)

                    textEmptyViewWeatherHoursList.visibility = View.GONE
                    listWeatherHour.visibility = View.VISIBLE
                    AdapterManager.initListHours(binding.listWeatherHour,context,weatherResponse)

            }
        }

        fun setEmptyRecycleView(titleTextView: TextView, listWeatherInfo: RecyclerView){
            titleTextView.visibility = View.VISIBLE
            listWeatherInfo.visibility = View.GONE
        }



    }

}