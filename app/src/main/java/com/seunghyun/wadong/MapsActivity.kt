package com.seunghyun.wadong

import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.seunghyun.wadong.databinding.ActivityMapsBinding
import kotlinx.android.synthetic.main.layout_found_bottom_sheet.*

class MapsActivity : BindingActivity<ActivityMapsBinding>(), MainViewController {
    private val viewModel by lazy { MainViewModel(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment) {
            getMapAsync(viewModel::onMapReady)
        }

        binding.apply {
            vm = viewModel
            BottomSheetBehavior.from(foundBottomSheet).state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    override fun getLayoutId() = R.layout.activity_maps
    override fun getContext() = this
    override fun showFoundBottomSheet() {
        Log.d("testing", "show")
        BottomSheetBehavior.from(foundBottomSheet).state = BottomSheetBehavior.STATE_HALF_EXPANDED
    }
}
