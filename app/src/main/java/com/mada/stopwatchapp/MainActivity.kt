package com.mada.stopwatchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mada.stopwatchapp.ui.theme.StopwatchAppTheme
import androidx.compose.material3.Surface
import com.mada.stopwatchapp.presentation.screen.StopwatchScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StopwatchAppTheme {
                Surface {
                    StopwatchScreen()
                }
            }
        }
    }
}
