package com.seunghyun.wadong

import android.os.Bundle
import com.google.android.gms.maps.SupportMapFragment
import com.seunghyun.wadong.databinding.ActivityMapsBinding

class MapsActivity : BindingActivity<ActivityMapsBinding>() {
    private val viewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment) {
            getMapAsync(viewModel::onMapReady)
        }

        binding.apply {
            vm = viewModel
        }
    }

    override fun getLayoutId() = R.layout.activity_maps
}
