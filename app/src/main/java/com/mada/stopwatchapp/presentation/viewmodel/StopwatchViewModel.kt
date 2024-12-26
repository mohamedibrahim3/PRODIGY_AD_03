package com.mada.stopwatchapp.presentation.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mada.stopwatchapp.data.StopwatchState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class StopwatchViewModel(private val preferences: SharedPreferences):ViewModel() {

    private val _state = MutableStateFlow(StopwatchState())
    val state: StateFlow<StopwatchState> = _state

    private var timerJob: Job? = null

    init {
        val savedMilliseconds = preferences.getLong("milliseconds", 0L)
        val wasRunning = preferences.getBoolean("isRunning", false)
        _state.value = StopwatchState(milliseconds = savedMilliseconds, isRunning = wasRunning)

        if (wasRunning) {
            startTimer()
        }
    }
    fun startTimer(){
        if(_state.value.isRunning) return
        _state.value = _state.value.copy(isRunning = true)
        saveState()

        timerJob = viewModelScope.launch {
            while (_state.value.isRunning){
                delay(10L)
                _state.value = _state.value.copy(
                    milliseconds = _state.value.milliseconds + 10
                )
                saveState()
            }
        }
    }
    fun pauseTimer() {
        _state.value = _state.value.copy(isRunning = false)
        timerJob?.cancel()
        saveState()
    }

    fun resetTimer() {
        pauseTimer()
        _state.value = StopwatchState()
        saveState()
    }
    private fun saveState(){
        preferences.edit().apply {
            putLong("milliseconds", _state.value.milliseconds)
            putBoolean("isRunning", _state.value.isRunning)
            apply()
        }
    }

}