package com.seunghyun.wadong.ui.add_story.story_edit

import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.seunghyun.wadong.R
import com.seunghyun.wadong.databinding.ActivityStoryEditBinding
import com.seunghyun.wadong.ui.BindingActivity
import com.seunghyun.wadong.ui.add_story.food.Restaurant
import kotlinx.android.synthetic.main.item_restaurant.*

class StoryEditActivity : BindingActivity<ActivityStoryEditBinding>() {
    private lateinit var item: Restaurant

    override fun getLayoutId() = R.layout.activity_story_edit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = intent.getSerializableExtra("item") as Restaurant
        binding.apply {
            item = this@StoryEditActivity.item
            selectPictureButton.setOnClickListener {
                startActivity(Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI))
            }
        }
        Glide.with(this@StoryEditActivity)
                .load(item.image)
                .into(foodImage)
    }
}