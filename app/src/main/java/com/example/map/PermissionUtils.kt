package com.example.map

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

object PermissionUtils {
    const val LOCATION_REQUEST_CODE = 101

    private val locationPermission = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)

    @RequiresApi(Build.VERSION_CODES.M)
    fun requestLocationPermission(activity: AppCompatActivity): Boolean {
        if (checkLocationPermission(activity))
            return true

        activity.requestPermissions(locationPermission, LOCATION_REQUEST_CODE)

        return false
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkLocationPermission(activity: AppCompatActivity) =
        activity.checkSelfPermission(locationPermission[0]) == PackageManager.PERMISSION_GRANTED
}