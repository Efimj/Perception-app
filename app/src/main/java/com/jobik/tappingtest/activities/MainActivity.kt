package com.jobik.tappingtest.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jobik.tappingtest.ui.components.layouts.ScreenLayout.ScrenLayout
import com.jobik.tappingtest.ui.theme.TappingTestTheme
import com.jobik.tappingtest.utils.ThemeUtil.ThemeUtil
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