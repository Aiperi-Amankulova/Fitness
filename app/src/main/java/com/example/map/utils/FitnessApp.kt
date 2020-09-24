package com.example.map.utils

import android.app.Application
import com.example.map.data.PreferenceHelper

class FitnessApp: Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.initPreference(applicationContext)
    }
}