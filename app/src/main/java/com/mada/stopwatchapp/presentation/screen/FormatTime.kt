package com.mada.stopwatchapp.presentation.screen

fun FormatTime(milliseconds: Long): String {
    val minutes = milliseconds / 60000
    val seconds = (milliseconds % 60000) / 1000
    val millis = (milliseconds % 1000) / 10

    return "%02d : %02d : %02d".format(minutes, seconds, millis)
}