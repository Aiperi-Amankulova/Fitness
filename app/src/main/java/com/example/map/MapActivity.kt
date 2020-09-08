package com.example.map

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import kotlinx.android.synthetic.main.activity_main.*

abstract class MapActivity : AppCompatActivity() {

    abstract  fun getResId() : Int
    abstract  fun getMapView() : Int

    private var mapView : MapView? = null

    protected var map : MapboxMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(applicationContext, BuildConfig.API_MAP)

        setContentView(getResId())
        mapView = findViewById(getMapView())
        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync {
            map = it
            it.setStyle(Style.SATELLITE_STREETS){

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