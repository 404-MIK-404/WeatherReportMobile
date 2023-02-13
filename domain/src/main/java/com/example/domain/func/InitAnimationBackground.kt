package com.example.domain.func

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.weatherapp.animation.AnimationActivity

class InitAnimationBackground {

    fun initAnimationBackground(context: Context): Drawable?{
        return ContextCompat.getDrawable(context, AnimationActivity.backgroundColor)
    }


}