//どのAPI、URLをたたくか

package com.example.dailyadviceapp

import retrofit2.http.GET

interface AdviceApi {
    @GET("advice")
    suspend fun getRandomAdvice(): AdviceResponse
}