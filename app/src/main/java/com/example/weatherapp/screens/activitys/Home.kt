package com.example.weatherapp.screens.activitys


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.weatherapp.*
import com.example.weatherapp.screens.adapters.FragmentsAdapter
import com.example.weatherapp.databinding.ActivityHomeBinding
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
    }

}