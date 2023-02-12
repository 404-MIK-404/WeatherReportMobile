package com.example.weatherapp.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import app.futured.donut.DonutProgressView
import com.example.datamod.response.WeatherResponse
import com.example.weatherapp.*
import com.example.weatherapp.animation.AnimationActivity
import com.example.weatherapp.databinding.ActivityWeatherCityBinding


class WeatherCity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherCityBinding

    private lateinit var viewDonutRain: DonutProgressView

    private lateinit var infoWeatherLayout: LinearLayout

    private lateinit var serviceIntent: Intent

    private var localTimeTimer: LocalTimeTimer = LocalTimeTimer()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityWeatherCityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init(intent.getParcelableExtra<WeatherResponse>("ResponseWeather")!!)
        initAnimation()
        initService()
        onTouchLayout()
    }


    private val updateTime: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context, p1: Intent) {
            localTimeTimer.changeTime(p1.getLongExtra(TimerService.TIME_EXTRA,0L),
                binding.tvLocalTimeDay,infoWeatherLayout,this@WeatherCity)
        }

    }

    private fun initService(){
        serviceIntent = Intent(applicationContext,TimerService::class.java)
        registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
    }

    private fun initAnimation(){
        binding.infoWeatherLayout.background = ContextCompat.getDrawable(this@WeatherCity, AnimationActivity.backgroundColor)
        AnimationActivity.initActivityAnimation(infoWeatherLayout.background)
    }


    private fun init(weatherResponse: WeatherResponse){
        infoWeatherLayout = findViewById(R.id.infoWeatherLayout)
        viewDonutRain = findViewById(R.id.viewDonutRain)
        InformationWeather.setValueWeatherHour(this@WeatherCity,binding,weatherResponse)
    }

    private fun onTouchLayout(){
        infoWeatherLayout.setOnTouchListener(object :OnSwipeTouchListener(this){
            override fun onSwipeRight() {
                var intent = Intent(this@WeatherCity, Home::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right)
                super.onSwipeLeft()
            }
        })
    }
}