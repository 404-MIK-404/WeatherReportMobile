package com.example.weatherapp.screens.activitys


import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.weatherapp.*
import com.example.weatherapp.screens.adapters.FragmentsAdapter
import com.example.weatherapp.databinding.ActivityHomeBinding
import com.example.weatherapp.screens.outinformation.InformationWeather
import com.example.weatherapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var viewPageFragments: ViewPager2

    private val vm: HomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPageFragments = findViewById(R.id.viewPageFragments)
        viewPageFragments.adapter = FragmentsAdapter(this)
        this.initAnimationBackground(binding)
        this.modeIsChangeEvent()
    }

    private fun initAnimationBackground(view: ActivityHomeBinding){
        val animBackground = view.root.background as AnimationDrawable
        animBackground.setEnterFadeDuration(10)
        animBackground.setExitFadeDuration(5000)
        animBackground.start()
    }


    private fun modeIsChangeEvent(){
        this.vm.getModeIsDark().observeForever { res -> Log.i("Test change dark mode", res.toString())}
    }



}