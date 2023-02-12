package com.example.weatherapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.weatherapp.R

class SplashScreen : AppCompatActivity() {

    private lateinit var inAnimation: Animation
    private lateinit var nameIntroWeather: TextView
    private lateinit var nameIntroReporter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        init()
        initAnimation()
        initPostDelayed()
    }

    private fun initAnimation(){
        inAnimation = AnimationUtils.loadAnimation(this, R.anim.anim)
        nameIntroWeather.startAnimation(inAnimation)
        nameIntroReporter.startAnimation(inAnimation)
    }

    private fun init(){
        nameIntroWeather = findViewById(R.id.nameIntroWeather)
        nameIntroReporter = findViewById(R.id.nameIntroReporter)
    }

    private fun initPostDelayed(){
        Handler().postDelayed(Runnable {
            startActivity(Intent(this, Home::class.java))
            finish()
        },6 * 1000)

    }


}