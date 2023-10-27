package com.jobik.perception.utils.ThemeUtil

import android.content.Context
import android.content.res.Configuration
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.jobik.perception.application.SharedPreferences.ApplicationStorageName
import com.jobik.perception.application.SharedPreferences.ApplicationUiMode

object ThemeUtil {
    private var _isDarkMode: MutableState<Boolean?> = mutableStateOf(null)
    var isDarkMode: MutableState<Boolean?>
        get() = _isDarkMode
        private set(value) {
            _isDarkMode = value
        }

    fun getSavedMode(context: Context): Boolean {
        val store = context.getSharedPreferences(ApplicationStorageName, Context.MODE_PRIVATE)
        val savedThemeString = store.getString(ApplicationUiMode, "")
        if (savedThemeString.isNullOrEmpty()) {
            isDarkMode.value =
                context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
        } else {
            isDarkMode.value = savedThemeString.toBoolean()
        }
        return isDarkMode.value!!
    }

    fun saveThemeMode(context: Context, mode: Boolean) {
        val store = context.getSharedPreferences(ApplicationStorageName, Context.MODE_PRIVATE)
        store.edit().putString(ApplicationUiMode, mode.toString()).apply()
        isDarkMode.value = mode
    }
}