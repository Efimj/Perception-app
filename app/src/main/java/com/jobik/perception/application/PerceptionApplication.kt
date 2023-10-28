package com.jobik.perception.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PerceptionApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}