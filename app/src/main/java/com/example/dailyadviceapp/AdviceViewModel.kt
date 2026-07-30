package com.example.dailyadviceapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import kotlinx.coroutines.launch


@HiltViewModel
class AdviceViewModel @Inject constructor(
    private val repository: AdviceRepository,
) : ViewModel() {
    var advice by mutableStateOf("初期値テスト")
        private set

    fun loadAdvice() {
        viewModelScope.launch {
            advice = repository.getAdvice().slip.advice

        }
    }}



