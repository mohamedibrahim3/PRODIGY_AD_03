package com.mada.stopwatchapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StopwatchViewModelFactory(private val application: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val preferences = application.getSharedPreferences("StopwatchPrefs", 0)
        return StopwatchViewModel(preferences) as T
    }
}