package com.seunghyun.wadong.ui.add_story.food

import android.os.Bundle
import com.seunghyun.wadong.R
import com.seunghyun.wadong.databinding.ActivityAddFoodStoryBinding
import com.seunghyun.wadong.ui.BindingActivity

class AddFoodStoryActivity : BindingActivity<ActivityAddFoodStoryBinding>(), FoodViewController {
    private val viewModel by lazy { AddFoodStoryViewModel(this) }

    override fun getLayoutId() = R.layout.activity_add_food_story

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            vm = viewModel
            recyclerView.adapter = FoodRecyclerViewAdapter(viewModel)
        }
    }
}