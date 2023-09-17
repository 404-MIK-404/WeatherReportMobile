package com.example.weatherapp.screens.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.WeatherHours
import com.example.weatherapp.databinding.WeatherCityHourItemBinding

class WeatherHoursAdapter: RecyclerView.Adapter<WeatherHoursAdapter.WeatherHoursHolder>() {


    val listWeatherHours = ArrayList<WeatherHours>()

    class WeatherHoursHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = WeatherCityHourItemBinding.bind(item)
        fun bind(weatherHours: WeatherHours) = with(binding){
            tvTimeWeatherCity.text = weatherHours.hour
            tvTimeTempHourWeatherCity.text = weatherHours.temp
            imageWeatherHourCity.setImageResource(weatherHours.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHoursHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_city_hour_item,parent,false)
        view.setPadding(25,0,25,0)
        return WeatherHoursHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherHoursHolder, position: Int) {
        holder.bind(listWeatherHours[position])
    }

    override fun getItemCount(): Int {
        return listWeatherHours.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addWeatherHours(weatherHours: WeatherHours){
        listWeatherHours.add(weatherHours)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearAllData(){
        listWeatherHours.clear()
        notifyDataSetChanged()
    }

}