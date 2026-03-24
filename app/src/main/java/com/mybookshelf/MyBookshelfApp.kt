package com.mybookshelf

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyBookshelfApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("MyBookshelf", "Application created")
    }
}
