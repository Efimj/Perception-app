package com.jobik.perception.application

import android.app.Application
import com.jobik.perception.database.PerceptionDB
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PerceptionApplication : Application() {
    val database by lazy { PerceptionDB.createDB(this) }
    override fun onCreate() {
        super.onCreate()
    }
}