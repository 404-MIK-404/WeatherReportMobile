package com.example.domain.func

import com.example.domain.repository.DarkModeRepository

class FindInfoAboutDarkMode(private val darkModeRepository: DarkModeRepository) {

    fun execute() : Boolean {
        return darkModeRepository.findInfoAboutDarkMode()
    }

}