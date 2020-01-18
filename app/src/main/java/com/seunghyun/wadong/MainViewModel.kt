package com.seunghyun.wadong

import androidx.databinding.ObservableField

class MainViewModel {
    val selectedCategory = ObservableField<Category>(Category.ALL)

    fun onCategoryButtonClick(clickedCategory: Category) {
        selectedCategory.set(clickedCategory)
    }
}