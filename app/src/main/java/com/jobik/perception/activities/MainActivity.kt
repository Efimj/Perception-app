package com.jobik.perception.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jobik.perception.ui.components.layouts.ScreenLayout.ScrenLayout
import com.jobik.perception.ui.theme.TappingTestTheme
import com.jobik.perception.utils.ThemeUtil.ThemeUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ThemeUtil.getSavedMode(this)

        setContent {
            TappingTestTheme(darkTheme = ThemeUtil.isDarkMode.value ?: true) {
                ScrenLayout()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TappingTestTheme {}
}