package com.seunghyun.wadong.ui.map

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.seunghyun.wadong.R
import com.seunghyun.wadong.databinding.ItemRestaurantBinding
import com.seunghyun.wadong.ui.add_story.food.Restaurant
import com.seunghyun.wadong.ui.add_story.food.getRestaurants

class FoodRecyclerViewAdapter : RecyclerView.Adapter<FoodRecyclerViewAdapter.FoodViewHolder>() {
    private val items = getRestaurants().shuffled()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = DataBindingUtil.inflate<ItemRestaurantBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_restaurant,
                parent,
                false
        )
        return FoodViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class FoodViewHolder(private val binding: ItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Restaurant) = binding.apply {
            this.item = item
            Glide.with(binding.root.context)
                    .load(item.image)
                    .into(foodImage)
        }
    }
}
