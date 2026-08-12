package com.example.dailyadviceapp

import android.R

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.dailyadviceapp.repositiry.AdviceRepository

import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@HiltViewModel
class AdviceViewModel @Inject constructor(
    private val repository: AdviceRepository,
) : ViewModel() {
    var advice by mutableStateOf("")
    var query by mutableStateOf("")
    var errorMessage by mutableStateOf("")

    var adviceId by mutableStateOf(0)


    fun loadAdvice(
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            try {
                advice = ""
                val response = repository.getAdvice()

                advice = response.slip.advice// ViewModelに保存
                adviceId = response.slip.id

                onSuccess()//取得成功後に画面遷移する
            } catch (e: Exception) {
                advice = "エラー: ${e.message}"
            }
        }
    }

    fun loadAdviceById(
        id: Int,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            try {
                advice = ""

                val response = repository.getAdviceById(id)

                advice = response.slip.advice
                adviceId = response.slip.id

                onSuccess()

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


