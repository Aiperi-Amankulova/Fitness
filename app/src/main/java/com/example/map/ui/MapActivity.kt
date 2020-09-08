package com.example.map.ui

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.map.BuildConfig
import com.example.map.PermissionUtils
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.location.modes.RenderMode
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style

abstract class MapActivity : AppCompatActivity() {


    abstract fun getResId(): Int
    abstract fun getMapView(): Int

    private var mapView: MapView? = null

    protected var map: MapboxMap? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(applicationContext, BuildConfig.API_MAP)
        setContentView(getResId())
        mapView = findViewById(getMapView())
        mapView?.onCreate(savedInstanceState)

        mapView?.getMapAsync {
            map = it
            it.setStyle(Style.TRAFFIC_NIGHT) {
                if (PermissionUtils.requestLocationPermission(this))
                    showUserLocation()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PermissionUtils.LOCATION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showUserLocation()
            }
        }
    }

    @SuppressLint("MissingPermission", "Range")
    private fun showUserLocation() {
        map?.style?.let {
            val locationComponent = map?.locationComponent
            locationComponent?.activateLocationComponent(
                LocationComponentActivationOptions.builder(applicationContext, it)
                    .build()
            )

//            locationComponent?.isLocationComponentEnabled = true
//            locationComponent?.cameraMode = CameraMode.TRACKING
//
//            locationComponent?.renderMode = RenderMode.COMPASS
//
//            val location = locationComponent?.lastKnownLocation
//
//            val latLng = LatLng(location?.latitude ?: 0.0, location?.longitude ?: 0.0)
//
//            val cm = CameraPosition.Builder()
//                .target(latLng)
//                .zoom(17.0)
//                .build()
//
//            map?.animateCamera(
//                CameraUpdateFactory.newCameraPosition(cm), 30000
//            )
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