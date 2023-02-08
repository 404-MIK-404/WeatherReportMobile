package com.example.weatherapp

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ScrollView
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

    private lateinit var scrollViewWeatherCity: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherCityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        initAnimation()
    }


    private fun initAnimation(){

        scrollViewWeatherCity = findViewById(R.id.scrollViewWeatherCity)
        val animationDrawable: AnimationDrawable = scrollViewWeatherCity.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start()

    }



    private fun init(){
        val section1 = DonutSection(
            name = "section_1",
            color = Color.parseColor("#FB1D32"),
            amount = 1.0f
        )
        /*
        val section2 = DonutSection(
            name = "section_2",
            color = Color.parseColor("#FFB98E"),
            amount = 1f
        )

         */
        viewDonutRain = findViewById(R.id.viewDonutRain)
        viewDonutRain.cap = 1.2f
        viewDonutRain.gapAngleDegrees = 90f
        viewDonutRain.submitData(listOf(section1))
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