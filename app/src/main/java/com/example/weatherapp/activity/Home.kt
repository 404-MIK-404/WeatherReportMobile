package com.example.weatherapp.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.datamod.list.ForecastDayList
import com.example.datamod.models.CurrentModel
import com.example.datamod.models.LocationModel
import com.example.datamod.response.WeatherResponse
import com.example.weatherapp.*
import com.example.weatherapp.animation.AnimationActivity
import com.example.weatherapp.databinding.ActivityHomeBinding
import com.example.weatherapp.viewmodel.HomeViewModel
import com.example.weatherapp.viewmodel.HomeViewModelFactory

class Home : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding

    private lateinit var searchViewCityWeather: SearchView

    private lateinit var homeLinearLayout: LinearLayout

    private lateinit var serviceIntent: Intent

    private var localTimeTimer: LocalTimeTimer = LocalTimeTimer()

    private lateinit var intentWeather: Intent

    private lateinit var vm: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        serviceIntent = Intent(applicationContext,TimerService::class.java)
        registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
        init()
    }

    private val updateTime: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context, p1: Intent) {
            localTimeTimer.changeTime(p1.getLongExtra(TimerService.TIME_EXTRA,0L),
                binding.valueTimeLocalCurrentCity,homeLinearLayout,applicationContext)
        }

    }

    private fun initAnimation(){
        binding.homeLinearLayout.background = ContextCompat.getDrawable(this@Home, AnimationActivity.backgroundColor)
        AnimationActivity.initActivityAnimation(homeLinearLayout.background)
    }

    private fun createViewModel(){
        vm = ViewModelProvider(this, HomeViewModelFactory(this)).get(HomeViewModel::class.java)
    }


    private fun initSearchViewCityEvent(){
        searchViewCityWeather.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                vm.findInfoAboutWeather(query.toString(),this@Home)
                return false
            }
        })
    }

    private fun initChangeValue(){
        vm.getResponseWeather().observe(this, Observer { response ->
            if (response != null){
                stopService(serviceIntent)
                setValueToPresentation(response)
                intentWeather.putExtra("ResponseWeather",response)
            }
        })

    }

    private fun setValueToPresentation(weatherResponse: WeatherResponse){
        InformationWeather.setValueWeatherDay(this@Home,binding,weatherResponse)
        localTimeTimer.setThemeDay(TimeFormatters.FULL_TIME_DATE.formatter.parse(weatherResponse.locationModel.localtime.toString()),homeLinearLayout,this@Home)
        serviceIntent.putExtra(TimerService.TIME_EXTRA,TimeFormatters.FULL_TIME_DATE.formatter.parse(weatherResponse.locationModel.localtime.toString())!!.time)
        startService(serviceIntent)
    }

    private fun init(){
        searchViewCityWeather = findViewById(R.id.searchViewCityWeather)
        homeLinearLayout = findViewById(R.id.homeLinearLayout)
        createViewModel()
        initRecyclerviewWeatherDays()
        initAnimation()
        initSearchViewCityEvent()
        initChangeValue()
        initClickLayout()
    }

    private fun initClickLayout(){
        homeLinearLayout.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {
                startActivity(intentWeather)
                overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left)
            }

        })
    }

    private fun initRecyclerviewWeatherDays(){
        vm.findResponseWeather(this@Home)
        intentWeather = Intent(this@Home, WeatherCity::class.java)
    }


}