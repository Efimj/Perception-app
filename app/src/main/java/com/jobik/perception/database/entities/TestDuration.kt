package com.jobik.perception.database.entities

import android.content.Context
import androidx.annotation.Keep
import com.jobik.perception.R

@Keep
enum class TestDuration(val durationInMinutes: Int) {
    QUICK(5),
    MEDIUM(15),
    LONG(30);

    fun getLocalizedValue(context: Context): String {
        val string: String = when (name) {
            QUICK.name -> context.getString(R.string.quick)
            MEDIUM.name -> context.getString(R.string.medium)
            LONG.name -> context.getString(R.string.long_duration)

            else -> ""
        }
        return string
    }
}