package com.mada.stopwatchapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mada.stopwatchapp.data.StopwatchState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class StopwatchViewModel:ViewModel() {

    private val _state = MutableStateFlow(StopwatchState())
    val state: StateFlow<StopwatchState> = _state

    private var timerJob: Job? = null

    fun startTime(){
        if(_state.value.isRunning) return
        _state.value = _state.value.copy(isRunning = true)

        timerJob = viewModelScope.launch {
            while (_state.value.isRunning){
                delay(10L)
                _state.value = _state.value.copy(
                    milliseconds = _state.value.milliseconds + 10
                )
            }
        }
    }
    fun pauseTimer() {
        _state.value = _state.value.copy(isRunning = false)
        timerJob?.cancel()
    }

    fun resetTimer() {
        pauseTimer()
        _state.value = StopwatchState()
    }

}