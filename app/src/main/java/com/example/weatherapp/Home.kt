package com.example.weatherapp

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.datamod.response.WeatherResponse
import com.example.weatherapp.adapters.WeatherDaysAdapter
import com.example.weatherapp.databinding.ActivityHomeBinding
import com.example.weatherapp.viewmodel.HomeViewModel
import com.example.weatherapp.viewmodel.HomeViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val adapter = WeatherDaysAdapter()
    private lateinit var searchViewCityWeather: SearchView
    private lateinit var viewNameCity: TextView


    private lateinit var homeLinearLayout: LinearLayout



    private lateinit var vm: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(this, HomeViewModelFactory(this)).get(HomeViewModel::class.java)
        init()
        initAnimation()
        initSearchViewCityEvent()
        initChangeValue()
    }

    private fun initAnimation(){

        val animationDrawable: AnimationDrawable = homeLinearLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start()

    }


    private fun initSearchViewCityEvent(){
        searchViewCityWeather.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                vm.findInfoAboutWeather(query.toString())
                return false
            }
        })
    }

    private fun initChangeValue(){
        vm.getResponseWeather().observe(this, Observer { resposne ->
            setValueToPresentation(resposne)
        })

    }

    private fun setValueToPresentation(response: WeatherResponse){
        adapter.clearAllData()

        with(binding){
            val location = response.locationModel
            val current = response.currentModel
            val forecast = response.forecastDayList
            viewNameCity.text = location.name
            valueTempWeather.text = current.temp_c + " °С"
            valueTimeLocalCurrentCity.text = location.localtime
            valueUV.text = current.uv
            valueHumidity.text = current.humidity
            for (item in forecast.forecastDayModel){
                val sdf: SimpleDateFormat  = SimpleDateFormat("yyyy-MM-dd")
                val date = sdf.parse(item.date.toString())
                adapter.addWeatherDay(WeatherDay(R.mipmap.partly_cloudy,
                    SimpleDateFormat("EE", Locale.ENGLISH).format(date.time),item.dayModel.avgtemp_c))
            }
        }
    }

    private fun init(){
        searchViewCityWeather = findViewById(R.id.searchViewCityWeather)
        homeLinearLayout = findViewById(R.id.homeLinearLayout)
        viewNameCity = findViewById(R.id.viewNameCity)

        binding.apply {
            listWeatherDays.layoutManager = GridLayoutManager(this@Home,5)
            listWeatherDays.adapter = adapter
            setChangeActivityToWeatherCity.setOnClickListener{
                var i: Intent = Intent(this@Home,WeatherCity::class.java)
                startActivity(i)
            }
        }
    }




}