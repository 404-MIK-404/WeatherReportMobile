package com.example.weatherapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import app.futured.donut.DonutProgressView
import app.futured.donut.DonutSection
import com.example.weatherapp.adapters.WeatherHoursAdapter
import com.example.weatherapp.data.WeatherHours
import com.example.weatherapp.databinding.ActivityWeatherCityBinding

class WeatherCity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherCityBinding
    private val adapter = WeatherHoursAdapter()
    private lateinit var viewDonutRain: DonutProgressView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherCityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    private fun init(){
        val section1 = DonutSection(
            name = "section_1",
            color = Color.parseColor("#FB1D32"),
            amount = 1f
        )
        val section2 = DonutSection(
            name = "section_2",
            color = Color.parseColor("#FFB98E"),
            amount = 1f
        )
        viewDonutRain = findViewById(R.id.viewDonutRain)
        viewDonutRain.cap = 5f
        viewDonutRain.submitData(listOf(section1,section2))
        binding.apply {

            listWeatherHour.layoutManager = LinearLayoutManager(this@WeatherCity,LinearLayoutManager.HORIZONTAL,false)
            listWeatherHour.adapter = adapter
            adapter.addWeatherHours(WeatherHours(R.mipmap.partly_cloudy,"18:00","20°"))
            adapter.addWeatherHours(WeatherHours(R.mipmap.partly_cloudy,"20:00","-14°"))
            adapter.addWeatherHours(WeatherHours(R.mipmap.partly_cloudy,"22:00","0°"))
            adapter.addWeatherHours(WeatherHours(R.mipmap.partly_cloudy,"00:00","-3°"))
            adapter.addWeatherHours(WeatherHours(R.mipmap.partly_cloudy,"00:00","-3°"))
            adapter.addWeatherHours(WeatherHours(R.mipmap.partly_cloudy,"00:00","-3°"))
            adapter.addWeatherHours(WeatherHours(R.mipmap.partly_cloudy,"00:00","-3°"))
            adapter.addWeatherHours(WeatherHours(R.mipmap.partly_cloudy,"00:00","-3°"))

        }
    }

}