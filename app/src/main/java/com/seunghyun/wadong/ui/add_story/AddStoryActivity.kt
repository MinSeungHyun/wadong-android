package com.seunghyun.wadong.ui.add_story

import android.content.Intent
import android.os.Bundle
import com.seunghyun.wadong.R
import com.seunghyun.wadong.databinding.ActivityAddStoryBinding
import com.seunghyun.wadong.ui.BindingActivity
import com.seunghyun.wadong.ui.add_story.food.AddFoodStoryActivity

class AddStoryActivity : BindingActivity<ActivityAddStoryBinding>() {
    override fun getLayoutId() = R.layout.activity_add_story

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity = this
    }

    fun onCardClick(title: String) {
        if (title == getString(R.string.food)) {
            startActivity(Intent(this, AddFoodStoryActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}