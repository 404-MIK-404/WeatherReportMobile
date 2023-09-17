package com.example.weatherapp.screens.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.SearchView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.domain.services.eventservice.LocalTimeTimer
import com.example.domain.services.TimerService
import com.example.weatherapp.databinding.FragmentHomeBinding
import com.example.weatherapp.screens.outinformation.InformationWeather
import com.example.weatherapp.viewmodel.HomeViewModel



class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding

    private val vm: HomeViewModel by activityViewModels()

    private lateinit var serviceIntent: Intent

    private var localTimeTimer: LocalTimeTimer = LocalTimeTimer()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root
        initService()
        init()
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        serviceIntent = Intent(context, TimerService::class.java)
        context?.registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
    }


    private fun initService(){
        serviceIntent = Intent(activity?.applicationContext, TimerService::class.java)
        activity?.registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
    }

    private fun initSearchViewCityEvent(){
        binding.searchViewCityWeather.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                vm.findInfoAboutWeather(query.toString(),activity?.baseContext!!)
                return false
            }
        })
    }

    private fun init(){
        vm.findResponseWeather(activity?.baseContext!!)
        initSearchViewCityEvent()
        initChangeValue()
        initSwitchDarkMode()
    }

    private fun initSwitchDarkMode(){
        this.vm.findInfoDarkMode()
        this.vm.getModeIsDark().observe(viewLifecycleOwner) { res ->
            binding.changeDarkMode.isChecked = res
        }
        binding.changeDarkMode.setOnCheckedChangeListener{ btnView, isChecked ->
            vm.changeDarkMode(isChecked)
        }
    }

    private fun initChangeValue(){
        vm.getResponseWeather().observe(viewLifecycleOwner, Observer { response ->
            try {
                if (response != null){
                    activity?.stopService(serviceIntent)
                }
                InformationWeather.setValueWeatherDay(context=activity?.baseContext!!,binding=binding, weatherResponse = response)
                vm.startServiceTime(context=activity?.baseContext!!, weatherResponse = response, serviceIntent = serviceIntent)
            } catch (_:java.lang.RuntimeException){
                InformationWeather.setEmptyRecycleView(binding.textEmptyViewWeatherDaysList,binding.listWeatherDays)
            }
        })
    }


    private val updateTime: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context, p1: Intent) {
            localTimeTimer.changeTime(p1.getLongExtra(TimerService.TIME_EXTRA,0L), binding.valueTimeLocalCurrentCity)
        }

    }



    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}