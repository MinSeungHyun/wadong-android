package com.seunghyun.wadong.ui.add_story.story_edit

import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.seunghyun.wadong.R
import com.seunghyun.wadong.databinding.ActivityStoryEditBinding
import com.seunghyun.wadong.ui.BindingActivity
import com.seunghyun.wadong.ui.add_story.food.Restaurant
import com.seunghyun.wadong.ui.map.MapsActivity
import kotlinx.android.synthetic.main.item_restaurant.*

private const val REQUEST_CODE = 777

class StoryEditActivity : BindingActivity<ActivityStoryEditBinding>() {
    private lateinit var item: Restaurant

    override fun getLayoutId() = R.layout.activity_story_edit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = intent.getSerializableExtra("item") as Restaurant
        binding.apply {
            item = this@StoryEditActivity.item
            selectPictureButton.setOnClickListener {
                startActivityForResult(Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), REQUEST_CODE)
            }
        }
        Glide.with(this@StoryEditActivity)
                .load(item.image)
                .into(foodImage)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            val intent = Intent(this, MapsActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                putExtra("isStoryAdded", true)
            }
            startActivity(intent)
        }
    }
}