package com.example.map

import android.app.Application
import com.example.map.data.PreferenceHelper

class Fitness_S: Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.initPreference(applicationContext)
    }
}