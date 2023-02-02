package com.example.weatherapp

import com.example.weatherapp.listeners.OnSwipeTouchListener
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
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


    @SuppressLint("ClickableViewAccessibility")
    private fun init(){
        binding.apply {
            listWeatherDays.layoutManager = GridLayoutManager(this@Home,5)
            listWeatherDays.adapter = adapter
            adapter.addWeatherDay(WeatherDay(R.mipmap.partly_cloudy,"Пн","20 °С"))
            adapter.addWeatherDay(WeatherDay(R.mipmap.partly_cloudy,"Вт","20 °С"))
            adapter.addWeatherDay(WeatherDay(R.mipmap.partly_cloudy,"Ср","20 °С"))
            adapter.addWeatherDay(WeatherDay(R.mipmap.partly_cloudy,"Чт","20 °С"))
            adapter.addWeatherDay(WeatherDay(R.mipmap.partly_cloudy,"Пт","20 °С"))
            setChangeActivityToWeatherCity.setOnClickListener{
                var i: Intent = Intent(this@Home,WeatherCity::class.java)
                startActivity(i)
            }
        }

    }


}