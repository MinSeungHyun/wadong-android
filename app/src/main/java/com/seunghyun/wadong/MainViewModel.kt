package com.seunghyun.wadong

import androidx.databinding.ObservableField
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainViewModel {
    val selectedCategory = ObservableField<Category>(Category.ALL)

    private lateinit var map: GoogleMap

    fun onCategoryButtonClick(clickedCategory: Category) {
        selectedCategory.set(clickedCategory)
    }

    fun onMapReady(map: GoogleMap) {
        this.map = map
        val currentLocation = LatLng(37.533623, 126.960609)

        map.apply {
            addMarker(MarkerOptions().position(currentLocation).title("현위치"))
            moveCamera(CameraUpdateFactory.newLatLng(currentLocation))
            moveCamera(CameraUpdateFactory.zoomTo(15f))
        }
    }
}