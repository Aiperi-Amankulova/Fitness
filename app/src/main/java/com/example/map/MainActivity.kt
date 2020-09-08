package com.example.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mapbox.mapboxsdk.maps.Style
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

}