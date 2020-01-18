package com.seunghyun.wadong.ui.add_story.food

import android.content.Intent
import android.os.Bundle
import com.seunghyun.wadong.R
import com.seunghyun.wadong.databinding.ActivityAddFoodStoryBinding
import com.seunghyun.wadong.ui.BindingActivity
import com.seunghyun.wadong.ui.add_story.story_edit.StoryEditActivity

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

    override fun getAdapter() = binding.recyclerView.adapter as FoodRecyclerViewAdapter
    override fun startStoryEditActivity(item: Restaurant) {
        startActivity(Intent(this, StoryEditActivity::class.java).apply {
            putExtra("item", item)
        })
    }
}