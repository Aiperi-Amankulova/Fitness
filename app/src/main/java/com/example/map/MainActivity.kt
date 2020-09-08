package com.example.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.map.BuildConfig.API_MAP
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.Style
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(applicationContext, API_MAP)
        setContentView(R.layout.activity_main)

        mapView?.onCreate(savedInstanceState)

        mapView?.getMapAsync {
            it.setStyle(Style.MAPBOX_STREETS)

        }

    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

}