package com.mada.stopwatchapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mada.stopwatchapp.presentation.viewmodel.StopwatchViewModel

@Composable
fun StopwatchScreen() {
    val viewModel: StopwatchViewModel = viewModel()
    val state = viewModel.state.collectAsState()

    StopwatchContent(
        time = state.value.milliseconds,
        onStart = { viewModel.startTime() },
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
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = FormatTime(time),
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = onStart) {
                Text("Start")
            }

            Button(onClick = onPause) {
                Text("Pause")
            }

            Button(onClick = onReset) {
                Text("Reset")
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