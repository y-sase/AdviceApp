//どのAPI、URLをたたくか

package com.example.dailyadviceapp

import retrofit2.http.GET
import retrofit2.http.Path

interface AdviceApi {
    @GET("advice")
    suspend fun getRandomAdvice(): AdviceResponse

    @GET("advice/{id}")
    suspend fun getAdviceById(@Path("id") adviceId:Int): AdviceResponse

}