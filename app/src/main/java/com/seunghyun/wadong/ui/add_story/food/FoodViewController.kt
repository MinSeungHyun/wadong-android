package com.seunghyun.wadong.ui.add_story.food

interface FoodViewController {
    fun getAdapter(): FoodRecyclerViewAdapter
    fun startStoryEditActivity(item: Restaurant)
}