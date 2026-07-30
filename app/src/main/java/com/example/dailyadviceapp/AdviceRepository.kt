//AdviceRepository機能を定義すること
package com.example.dailyadviceapp

interface AdviceRepository {

    suspend fun getAdvice(): AdviceResponse
}