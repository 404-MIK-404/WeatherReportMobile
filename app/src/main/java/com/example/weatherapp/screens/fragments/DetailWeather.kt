package com.example.weatherapp.screens.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.domain.services.eventservice.LocalTimeTimer
import com.example.domain.services.TimerService
import com.example.weatherapp.animation.AnimationActivity
import com.example.weatherapp.databinding.FragmentDetailWeatherBinding
import com.example.weatherapp.screens.outinformation.InformationWeather
import com.example.weatherapp.viewmodel.HomeViewModel


class DetailWeather : Fragment() {

    private val vm: HomeViewModel by activityViewModels()

    private lateinit var binding: FragmentDetailWeatherBinding

    private lateinit var serviceIntent: Intent

    private var localTimeTimer: LocalTimeTimer = LocalTimeTimer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        serviceIntent = Intent(activity?.applicationContext!!, TimerService::class.java)
        activity?.registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailWeatherBinding.inflate(inflater,container,false)
        val view = binding.root
        setEventChangeValue()
        return view
    }

    private fun setEventChangeValue(){

        vm.getResponseWeather().observe(viewLifecycleOwner, Observer { response ->
            try {
                InformationWeather.setValueWeatherHour(activity?.baseContext!!,binding, response)
            } catch (_:java.lang.RuntimeException){
                InformationWeather.setEmptyRecycleView(titleTextView = binding.textEmptyViewWeatherHoursList, listWeatherInfo = binding.listWeatherHour)
            } finally {
                vm.initAnimation(activity?.baseContext!!)
            }
        })

        vm.getBackgroundFragment().observe(viewLifecycleOwner, Observer { color ->
            binding.infoWeatherLayout.background = color
            AnimationActivity.initActivityAnimation(binding.infoWeatherLayout.background)
        })
    }



    private val updateTime: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context, p1: Intent) {
            localTimeTimer.changeTime(p1.getLongExtra(TimerService.TIME_EXTRA,0L),
                binding.tvLocalTimeDay,binding.infoWeatherLayout,activity?.baseContext!!)
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailWeather()

    }
}