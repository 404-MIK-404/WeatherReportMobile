package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.adapters.WeatherHoursAdapter
import com.example.weatherapp.data.WeatherHours
import com.example.weatherapp.databinding.ActivityHomeBinding
import com.example.weatherapp.databinding.ActivityWeatherCityBinding
import com.example.weatherapp.databinding.WeatherCityHourItemBinding

class WeatherCity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherCityBinding
    private val adapter = WeatherHoursAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherCityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    private fun init(){
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