package com.mada.stopwatchapp.presentation.screen

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mada.stopwatchapp.presentation.viewmodel.StopwatchViewModel
import com.mada.stopwatchapp.presentation.viewmodel.StopwatchViewModelFactory


@Composable
fun StopwatchScreen() {
    val context = LocalContext.current.applicationContext as Application
    val viewModel: StopwatchViewModel = viewModel(
        factory = StopwatchViewModelFactory(context)
    )
    val state = viewModel.state.collectAsState()

    StopwatchContent(
        time = state.value.milliseconds,
        onStart = { viewModel.startTimer() },
        onPause = { viewModel.pauseTimer() },
        onReset = { viewModel.resetTimer() }
    )
}

@Composable
fun StopwatchContent(
    time: Long,
    onStart: () -> Unit,
    onPause: () -> Unit,
    onReset: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFF1F1F1F), shape = RoundedCornerShape(16.dp))
                .padding(24.dp)

        ) {
            Text(
                text = FormatTime(time),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = onStart,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF388E3C)),
                modifier = Modifier.weight(1f)
            ) {
                Text("Start", color = Color.White)
            }

            Button(
                onClick = onPause,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF388E3C)),
                modifier = Modifier.weight(1f)
            ) {
                Text("Pause", color = Color.White)
            }

            Button(
                onClick = onReset,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF388E3C)),
                modifier = Modifier.weight(1f)
            ) {
                Text("Reset", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StopwatchPreview() {
    MaterialTheme {
        StopwatchContent(
            time = 123456L,
            onStart = {},
            onPause = {},
            onReset = {}
        )
    }
}