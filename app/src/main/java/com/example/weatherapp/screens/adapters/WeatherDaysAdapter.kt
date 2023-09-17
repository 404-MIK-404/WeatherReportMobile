package com.example.weatherapp.screens.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.WeatherDay
import com.example.weatherapp.databinding.Weather5DayItemBinding

class WeatherDaysAdapter: RecyclerView.Adapter<WeatherDaysAdapter.WeatherDaysHolder>() {


    val weatherDayList = ArrayList<WeatherDay>()

    class WeatherDaysHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = Weather5DayItemBinding.bind(item)
        fun bind(weatherDay: WeatherDay) = with(binding){
            imageWeather.setImageResource(weatherDay.image)
            tvNameDay.text = weatherDay.nameDay
            tvAvgTempWeatherDay.text = weatherDay.avgTemp
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDaysHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_5_day_item,parent,false)
        return WeatherDaysHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherDaysHolder, position: Int) {
        holder.bind(weatherDayList[position])
    }

    override fun getItemCount(): Int {
        return weatherDayList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addWeatherDay(weatherDay: WeatherDay){
        weatherDayList.add(weatherDay)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearAllData(){
        weatherDayList.clear()
        notifyDataSetChanged()
    }


}

