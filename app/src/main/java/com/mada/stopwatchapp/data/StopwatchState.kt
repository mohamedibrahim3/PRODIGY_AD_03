package com.mada.stopwatchapp.data

data class StopwatchState(
    val milliseconds: Long = 0L,
    val isRunning: Boolean = false
)
