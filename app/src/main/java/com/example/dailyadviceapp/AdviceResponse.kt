//返ってくるAPI、JSONの型

package com.example.dailyadviceapp


data class AdviceResponse(
    val slip: Slip
)

data class Slip(
    val id: Int,
    val advice: String
)

