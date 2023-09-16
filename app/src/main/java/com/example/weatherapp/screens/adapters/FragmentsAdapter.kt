package com.example.weatherapp.screens.adapters

import android.content.res.Resources
import android.graphics.drawable.AnimationDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.weatherapp.screens.fragments.DetailWeather
import com.example.weatherapp.screens.fragments.HomeFragment

class FragmentsAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return HomeFragment()
            1 -> return DetailWeather()
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }
    }

}