package com.example.map.ui.utils

import android.app.Application
import com.example.map.ui.data.PreferenceHelper

class FitnessApp: Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.initPreference(applicationContext)
    }

}