package com.example.map.onBoarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.map.R
import com.example.map.data.PreferenceHelper
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        setupListeners()
    }

    private fun setupListeners() {
        btn.setOnClickListener {
            PreferenceHelper.setIsFirstLaunch()
            startActivity(Intent(this, OnBoardingActivity::class.java))
        }
    }
}
