package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {


    private lateinit var inAnimation: Animation
    private lateinit var imageSplash: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        init()
    }


    private fun init(){
        imageSplash = findViewById(R.id.imageSplash)
        inAnimation = AnimationUtils.loadAnimation(this,R.anim.anim)
        imageSplash.startAnimation(inAnimation)
        Handler().postDelayed(Runnable {
           var i: Intent = Intent(this,Home::class.java)
            startActivity(i)
            finish()

        },6 * 1000)


    }



}