package com.example.map.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.map.BuildConfig
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style

abstract class SupportMapActivity: AppCompatActivity() {
    abstract fun getResId(): Int
    abstract fun getMapViewId(): Int
    abstract fun onMapLoaded(mapBoxMap: MapboxMap, style: Style)

    protected var mapView: MapView? = null
    protected var map: MapboxMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(applicationContext, BuildConfig.API_MAP)
        setContentView(getResId())
        mapView = findViewById(getMapViewId())
        mapView?.onCreate(savedInstanceState)

        mapView?.getMapAsync { mapBoxMap ->
            map = mapBoxMap
            mapBoxMap.setStyle(Style.MAPBOX_STREETS) { style ->
                onMapLoaded(mapBoxMap, style)
            }
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

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }


    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }

}