package com.example.domain.repository

interface DarkModeRepository {

    fun findInfoAboutDarkMode() : Boolean;

    fun setDarkMode(mode: Boolean)

}