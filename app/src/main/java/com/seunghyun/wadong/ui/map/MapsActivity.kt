package com.seunghyun.wadong.ui.map

import android.content.Intent
import android.os.Bundle
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.seunghyun.wadong.R
import com.seunghyun.wadong.databinding.ActivityMapsBinding
import com.seunghyun.wadong.ui.BindingActivity
import com.seunghyun.wadong.ui.add_story.AddStoryActivity
import com.seunghyun.wadong.ui.story.StoryActivity
import kotlinx.android.synthetic.main.layout_found_bottom_sheet.*

class MapsActivity : BindingActivity<ActivityMapsBinding>(), MapViewController {
    private val viewModel by lazy { MainViewModel(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment) {
            getMapAsync(viewModel::onMapReady)
        }

        binding.apply {
            vm = viewModel
            BottomSheetBehavior.from(foundBottomSheet).state = BottomSheetBehavior.STATE_HIDDEN
            recyclerView.adapter = FoodRecyclerViewAdapter()
        }

        viewModel.isStoryAdded = intent.getBooleanExtra("isStoryAdded", false)
    }

    override fun getLayoutId() = R.layout.activity_maps
    override fun getContext() = this
    override fun showFoundBottomSheet() {
        BottomSheetBehavior.from(foundBottomSheet).state = BottomSheetBehavior.STATE_HALF_EXPANDED
    }

    override fun startAddStoryActivity() = startActivity(Intent(this, AddStoryActivity::class.java))
    override fun startStoryActivity() = startActivity(Intent(this, StoryActivity::class.java))
}
