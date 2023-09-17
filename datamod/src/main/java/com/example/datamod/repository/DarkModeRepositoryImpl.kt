package com.example.datamod.repository

import com.example.datamod.storage.DarkModeStorage
import com.example.domain.repository.DarkModeRepository

class DarkModeRepositoryImpl(private val darkModeStorage: DarkModeStorage) : DarkModeRepository {

    override fun findInfoAboutDarkMode(): Boolean {
        return darkModeStorage.infoDarkMode()
    }

    override fun setDarkMode(mode: Boolean) {
        darkModeStorage.setDarkMode(mode = mode)
    }
}