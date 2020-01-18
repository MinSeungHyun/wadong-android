package com.seunghyun.wadong

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        with(supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment) {
            getMapAsync(this@MapsActivity)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val currentLocation = LatLng(37.533623, 126.960609)

        map.apply {
            addMarker(MarkerOptions().position(currentLocation).title("현위치"))
            moveCamera(CameraUpdateFactory.newLatLng(currentLocation))
            moveCamera(CameraUpdateFactory.zoomTo(15f))
        }
    }
}
