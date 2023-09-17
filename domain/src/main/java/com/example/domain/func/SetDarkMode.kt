package com.example.domain.func

import com.example.domain.repository.DarkModeRepository

class SetDarkMode(private val darkModeRepository: DarkModeRepository) {

    fun execute(mode: Boolean){
        darkModeRepository.setDarkMode(mode=mode)
    }

}