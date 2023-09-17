package com.example.weatherapp.screens.activitys


import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.app.TaskStackBuilder
import androidx.viewpager2.widget.ViewPager2
import com.example.weatherapp.*
import com.example.weatherapp.databinding.ActivityHomeBinding
import com.example.weatherapp.screens.adapters.FragmentsAdapter
import com.example.weatherapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var viewPageFragments: ViewPager2

    private val vm: HomeViewModel by viewModels()

    private var firstLoadApp: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val modeIs = vm.getModeIsDarkV2()
        if (modeIs != null){
            if (modeIs == true){
                setTheme(R.style.DarkThemeApp)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                setTheme(R.style.NotDarkThemeApp)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            initAnimationBackground()
        }
        setContentView(binding.root)
        viewPageFragments = findViewById(R.id.viewPageFragments)
        viewPageFragments.adapter = FragmentsAdapter(this)
        this.modeIsChangeEvent()
    }

    private fun initAnimationBackground(){
        val animBackground = binding.root.background as AnimationDrawable
        animBackground.setEnterFadeDuration(10)
        animBackground.setExitFadeDuration(5000)
        animBackground.start()
    }

    private fun modeIsChangeEvent(){
        this.vm.getModeIsDark().observeForever { res ->
            if (res == true){
                this.binding.root.background =  AppCompatResources.getDrawable(binding.root.context, com.example.domain.R.drawable.dark_mode_init_anim_on)
            } else {
                this.binding.root.background =  AppCompatResources.getDrawable(binding.root.context, com.example.domain.R.drawable.not_dark_mode_init_anim)
            }
            if (!this.firstLoadApp){
                this.firstLoadApp = true
            } else {
                recreate()
            }
            Log.i("Test change dark mode", res.toString())

        }
    }


}