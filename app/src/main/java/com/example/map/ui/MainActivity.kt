package com.example.map.ui

import android.os.Bundle
import com.example.map.R

class MainActivity : MapActivity() {

    override  fun getResId() = R.layout.activity_main
    override  fun getMapView() = R.id.mapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}