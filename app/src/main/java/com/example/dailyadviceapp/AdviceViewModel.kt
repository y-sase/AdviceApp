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
    var advice by mutableStateOf("")
        private set


    fun loadAdvice(
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            try {
                advice = ""
                val response = repository.getAdvice()
                advice = response.slip.advice// ViewModelに保存
                onSuccess()//取得成功後に画面遷移する
            } catch (e: Exception) {
                advice = "エラー: ${e.message}"
            }
        }
    }
}

    /*
    fun loadAdvice() {
        viewModelScope.launch {
            advice = repository.getAdvice().slip.advice

        }
    }
}
*/


