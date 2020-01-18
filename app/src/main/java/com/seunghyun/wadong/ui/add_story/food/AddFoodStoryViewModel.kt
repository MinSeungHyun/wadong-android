package com.seunghyun.wadong.ui.add_story.food

import androidx.databinding.Observable
import androidx.databinding.ObservableField

class AddFoodStoryViewModel(private val controller: FoodViewController) {
    private val originalItems = getRestaurants()
    private val adapter by lazy { controller.getAdapter() }

    val searchingText = ObservableField<String>("")

    init {
        searchingText.observe {
            updateList()
        }
    }

    private fun updateList() = adapter.apply {
        items = originalItems.filter { it.name.contains(searchingText.get()!!) }
        notifyDataSetChanged()
    }
}

private fun <T> ObservableField<T>.observe(onChanged: () -> Unit) {
    this.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            onChanged.invoke()
        }
    })
}