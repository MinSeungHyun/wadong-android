package com.seunghyun.wadong

import android.content.Context

interface MainViewController {
    fun getContext(): Context
    fun showFoundBottomSheet()
}