//AdviceRepository機能を定義すること
package com.example.dailyadviceapp.repositiry

import com.example.dailyadviceapp.AdviceResponse

interface AdviceRepository {

    suspend fun getAdvice(): AdviceResponse
    suspend fun getAdviceById(
        id: Int
    ): AdviceResponse
}