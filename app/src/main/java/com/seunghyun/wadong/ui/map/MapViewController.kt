package com.seunghyun.wadong.ui.map

import android.content.Context

interface MapViewController {
    fun getContext(): Context
    fun showFoundBottomSheet()
    fun startAddStoryActivity()
    fun startStoryActivity()
    fun showPointDialog()
}