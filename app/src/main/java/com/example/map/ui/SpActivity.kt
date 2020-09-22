package com.example.map.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.map.R
import com.example.map.ui.data.PreferenceHelper
import com.example.map.ui.onBoarding.OnBoardingActivity

class SpActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)
        Handler().postDelayed({
            selectActivity()
        },3000)

    }

    private fun selectActivity(){
        if (PreferenceHelper.getIsFirtstLaunch()){
            startActivity(Intent(applicationContext, OnBoardingActivity:: class.java))
            finish()
        }
        else {
            startActivity(Intent(this, OnBoardingActivity::class.java))
            finish()
        }
    }
}