package com.khater.donut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                Color.Transparent.toArgb(),
                Color.Transparent.toArgb(),
                detectDarkMode = {
                    false
                }
            ), navigationBarStyle =SystemBarStyle.auto(
                Color.Transparent.toArgb(),
                Color.Transparent.toArgb(),
                detectDarkMode = {
                    true
                }
            ) )
        setContent {
            DonutApp()
        }
    }
}

