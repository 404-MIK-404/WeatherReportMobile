package com.example.datamod.sharedrefs

import android.content.Context
import com.example.datamod.storage.DarkModeStorage

private const val SHARED_PREFS_NAME = "shared_prefs_dark_mode"
private const val KEY_DARK_MODE = "Dark mode"

class SharedPrefDarkModeStorage(context: Context) : DarkModeStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun infoDarkMode(): Boolean {
        return sharedPreferences.getBoolean(KEY_DARK_MODE, false)
    }


    override fun setDarkMode(mode: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_DARK_MODE, mode).apply()
    }
}