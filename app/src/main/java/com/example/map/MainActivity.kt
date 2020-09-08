package com.example.map

import android.os.Bundle

class MainActivity : MapActivity() {

    override  fun getResId() = R.layout.activity_main
    override  fun getMapView() = R.id.mapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}