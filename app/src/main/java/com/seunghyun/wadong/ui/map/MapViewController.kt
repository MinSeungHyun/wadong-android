package com.seunghyun.wadong.ui.map

import android.content.Context

interface MapViewController {
    fun getContext(): Context
    fun showFoundBottomSheet()
}