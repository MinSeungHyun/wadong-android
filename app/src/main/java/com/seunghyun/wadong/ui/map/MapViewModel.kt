package com.seunghyun.wadong.ui.map

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Handler
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableField
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.seunghyun.wadong.R
import com.seunghyun.wadong.models.Category
import com.seunghyun.wadong.models.LuckBag

private val LUCK_LOCATIONS = listOf(
        LuckBag("용산구 한강대로", LatLng(37.529815, 126.964352)),
        LuckBag("용산꿈나무도서관", LatLng(37.538525, 126.965432)),
        LuckBag("전자랜드 용산점", LatLng(37.532732, 126.958926)),
        LuckBag("원효전자상가", LatLng(37.533626, 126.960566)),
        LuckBag("남정초등학교", LatLng(37.536264, 126.965140))
)

private var isShowed = false

class MainViewModel(private val controller: MapViewController) {
    val selectedCategory = ObservableField<Category>(Category.ALL)
    var isStoryAdded = false

    private lateinit var map: GoogleMap

    fun onCategoryButtonClick(clickedCategory: Category) {
        selectedCategory.set(clickedCategory)
    }

    fun onAddButtonClick() = controller.startAddStoryActivity()
    fun onRankButtonClick() = controller.showPointDialog()

    fun onMapReady(map: GoogleMap) {
        this.map = map
        val currentLocation = LatLng(37.534753, 126.964309)

        map.apply {
            setOnMarkerClickListener {
                if (it.title == "내 스토리") {
                    controller.startStoryActivity()
                } else {
                    controller.showFoundBottomSheet()
                }
                false
            }

            moveCamera(CameraUpdateFactory.newLatLng(currentLocation))
            moveCamera(CameraUpdateFactory.zoomTo(15f))

            val circle = CircleOptions()
                    .radius(200.0)
                    .fillColor(Color.parseColor("#6BFC6767"))
                    .strokeColor(Color.parseColor("#C6FC6767"))
                    .strokeWidth(5f)

            val luckDrawable = ContextCompat.getDrawable(controller.getContext(), R.drawable.luck_icon)!!.current as BitmapDrawable
            val luckBitmap = Bitmap.createScaledBitmap(luckDrawable.bitmap, 70, 70, false)
            val marker = MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(luckBitmap))

            LUCK_LOCATIONS.forEach {
                addCircle(circle.center(it.latLng))
                addMarker(marker.position(LatLng(it.latLng.latitude - 0.0003, it.latLng.longitude)))
                if (isStoryAdded) addMarker(MarkerOptions().position(LatLng(37.533771, 126.960510)).title("내 스토리"))
            }
        }

        if (!isShowed) {
            Handler().postDelayed({
                controller.showLuckFoundDialog()
                isShowed = true
            }, 2000)
        }
    }
}