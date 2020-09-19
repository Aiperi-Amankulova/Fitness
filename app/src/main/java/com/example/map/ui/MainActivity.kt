package com.example.map.ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.map.R

class MainActivity : MapActivity() {

    override  fun getResId() = R.layout.activity_main
    override  fun getMapView() = R.id.mapView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}