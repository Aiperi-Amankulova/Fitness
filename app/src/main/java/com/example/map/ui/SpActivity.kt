package com.example.map.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.map.R
import com.example.map.data.PreferenceHelper
import com.example.map.onBoarding.OnBoardingActivity

class SpActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)
        Handler().postDelayed({
            selectActivity()
        },4000)

    }

    private fun selectActivity(){
        if (PreferenceHelper.getIsSecondLaunch()){
            startActivity(Intent(applicationContext, OnBoardingActivity:: class.java))
            finish()
        }
        else {
            startActivity(Intent(this, OnBoardingActivity::class.java))
            finish()
        }
    }
}