package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.adapters.WeatherDaysAdapter
import com.example.weatherapp.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val adapter = WeatherDaysAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    private fun init(){
        binding.apply {
            listWeatherDays.layoutManager = GridLayoutManager(this@Home,5)
            listWeatherDays.adapter = adapter
            adapter.addWeatherDay(WeatherDay(R.mipmap.partly_cloudy,"Пн","20 °С"))
            adapter.addWeatherDay(WeatherDay(R.mipmap.partly_cloudy,"Вт","20 °С"))
            adapter.addWeatherDay(WeatherDay(R.mipmap.partly_cloudy,"Ср","20 °С"))
            adapter.addWeatherDay(WeatherDay(R.mipmap.partly_cloudy,"Чт","20 °С"))
            adapter.addWeatherDay(WeatherDay(R.mipmap.partly_cloudy,"Пт","20 °С"))
        }
    }

}