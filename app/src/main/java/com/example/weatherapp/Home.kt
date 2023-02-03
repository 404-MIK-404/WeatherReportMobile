package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.weatherapp.adapters.WeatherDaysAdapter
import com.example.weatherapp.databinding.ActivityHomeBinding
import com.example.weatherapp.viewmodel.HomeViewModel

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val adapter = WeatherDaysAdapter()
    private lateinit var searchViewCityWeather: SearchView
    private lateinit var viewNameCity: TextView


    private lateinit var vm: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(this,HomeViewModelFactory(this)).get(HomeViewModel::class.java)
        init()
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun init(){
        searchViewCityWeather = findViewById(R.id.searchViewCityWeather)
        viewNameCity = findViewById(R.id.viewNameCity)
        searchViewCityWeather.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                vm.saveCity(query.toString())
                vm.getCity()
                return false
            }
        })

        vm.getCityLive().observe(this, Observer {  text ->
            viewNameCity.text = text
        })

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