package com.example.domain.enums

import com.example.domain.R


class CodeIconWeather
{

    companion object{

        fun setPictureWeather(code: String) : Int{

            when (code){
                "Sunny" -> return R.mipmap.clear_day
                "Partly cloudy" -> return R.mipmap.partly_cloudy_day
                "Cloudy" -> return R.mipmap.cloudy
                "Overcast" -> return R.mipmap.overcast
                "Mist" -> return R.mipmap.fog
                "Patchy rain possible" -> return R.mipmap.heavy_showers
                "Patchy snow possible" -> return R.mipmap.sleet
                "Patchy sleet possible" -> return R.mipmap.snow
                "Thundery outbreaks possible" -> return R.mipmap.thunderstorm_showers
                "Blowing snow" -> return R.mipmap.heavy_showers
                "Blizzard" -> return R.mipmap.thunderstorm_snow
                "Fog" -> return R.mipmap.fog
                "Freezing fog" -> return R.mipmap.thunderstorm_snow
                "Patchy light drizzle" -> return R.mipmap.showers
                "Light drizzle" -> return R.mipmap.showers
                "Freezing drizzle" -> return R.mipmap.snow
                "Heavy freezing drizzle" -> return R.mipmap.heavy_sleet
                "Patchy light rain" -> return R.mipmap.showers
                "Light rain" -> return R.mipmap.showers
                "Moderate rain at times" -> return R.mipmap.showers
                "Moderate rain" -> return R.mipmap.showers
                "Heavy rain at times" -> return R.mipmap.showers
                "Heavy rain" -> return R.mipmap.heavy_showers
                "Light freezing rain" -> return R.mipmap.sleet
                "Moderate or heavy freezing rain" -> return R.mipmap.thunderstorm_snow
                "Light sleet" -> return R.mipmap.sleet
                "Moderate or heavy sleet" -> return R.mipmap.heavy_sleet
                "Patchy light snow" -> return R.mipmap.snow
                "Light snow" -> return R.mipmap.snow
                "Patchy moderate snow" -> return R.mipmap.snow
                "Moderate snow" -> return R.mipmap.snow
                "Patchy heavy snow" -> return R.mipmap.heavy_snow
                "Heavy snow" -> return R.mipmap.heavy_snow
                "Ice pellets" -> return R.mipmap.heavy_sleet
                "Light rain shower" -> return R.mipmap.sleet
                "Moderate or heavy rain shower" -> return R.mipmap.heavy_showers
                "Torrential rain shower" -> return R.mipmap.thunderstorm_showers
                "Light sleet showers" -> return R.mipmap.sleet
                "Moderate or heavy sleet showers" -> return R.mipmap.heavy_sleet
                "Light snow showers" -> return R.mipmap.sleet
                "Moderate or heavy snow showers" -> return R.mipmap.heavy_snow
                "Light showers of ice pellets" -> return R.mipmap.sleet
                "Moderate or heavy showers of ice pellets" -> return R.mipmap.heavy_sleet
                "Patchy light rain with thunder" -> return R.mipmap.thunderstorm_showers
                "Moderate or heavy rain with thunder" -> return R.mipmap.thunderstorm_showers
                "Patchy light snow with thunder" -> return R.mipmap.thunderstorm_snow
                "Moderate or heavy snow with thunder" -> return R.mipmap.thunderstorm_snow
            }
            return R.mipmap.cloudy
        }

    }
}