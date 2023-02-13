package com.example.weatherapp.animation

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Handler
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.domain.R


object AnimationActivity {

    private lateinit var animationDrawable: AnimationDrawable

    var backgroundColor: Int = R.drawable.animation_morning

    private fun startAnimation(){
        animationDrawable.start()
    }

    private fun stopAnimation(){
        animationDrawable.stop()
    }


     fun initActivityAnimation(drawableObj: Drawable?){
         animationDrawable = drawableObj as AnimationDrawable
         animationDrawable.setEnterFadeDuration(2500)
         animationDrawable.setExitFadeDuration(5000)
         startAnimation()
    }


    private fun getCicle(context: Context,changeCommand: String): Array<Drawable?>{
        when(changeCommand){
            "m->d" -> return arrayOf(ContextCompat.getDrawable(context,
                R.drawable.gradient_start_morning
            ), ContextCompat.getDrawable(context, R.drawable.gradient_start_day))

            "d->e" -> return arrayOf(ContextCompat.getDrawable(context,
                R.drawable.gradient_start_day
            ), ContextCompat.getDrawable(context, R.drawable.gradient_start_evening))

            "e->n" -> return arrayOf(ContextCompat.getDrawable(context,
                R.drawable.gradient_start_evening
            ), ContextCompat.getDrawable(context, R.drawable.gradient_start_night))

            "n->m" -> return arrayOf(ContextCompat.getDrawable(context,
                R.drawable.gradient_start_night
            ), ContextCompat.getDrawable(context, R.drawable.gradient_start_morning))


            "d" -> return arrayOf(ContextCompat.getDrawable(context,
                R.drawable.gradient_start_morning
            ), ContextCompat.getDrawable(context, R.drawable.gradient_start_day))

            "e" -> return arrayOf(ContextCompat.getDrawable(context,
                R.drawable.gradient_start_morning
            ), ContextCompat.getDrawable(context, R.drawable.gradient_start_evening))

            "n" -> return arrayOf(ContextCompat.getDrawable(context,
                R.drawable.gradient_start_morning
            ), ContextCompat.getDrawable(context, R.drawable.gradient_start_night))

            else -> return arrayOf(ContextCompat.getDrawable(context,
                R.drawable.gradient_start_morning
            ), ContextCompat.getDrawable(context, R.drawable.gradient_start_morning))
        }
    }

    fun getColorSetBackground(changeCommand: String): Int{
        when (changeCommand){

            "m->d" -> return R.drawable.animation_day
            "d->e" -> return R.drawable.animation_evening
            "e->n" -> return R.drawable.animation_night
            "n->m" -> return R.drawable.animation_morning

            "m" -> return R.drawable.animation_morning
            "d" -> return R.drawable.animation_day
            "e"-> return R.drawable.animation_evening
            "n"-> return R.drawable.animation_night
             else -> return backgroundColor
        }
    }




    fun changeColor(layout: LinearLayout?,context: Context,changeCommand: String){
        backgroundColor = getColorSetBackground(changeCommand=changeCommand)
        Handler().postDelayed(Runnable {
            stopAnimation()
            val mTransition = TransitionDrawable(getCicle(context = context,changeCommand=changeCommand))
            layout?.background = mTransition
            mTransition.startTransition(2000)
            Handler().postDelayed(Runnable {
                layout?.setBackgroundDrawable(ContextCompat.getDrawable(context, backgroundColor))
                initActivityAnimation(layout?.background)
                                           }, 2200)

        },1200)
    }






}