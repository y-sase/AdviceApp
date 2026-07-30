//Repository:AdviceRepository インターフェースを実装して、内部で AdviceApi を呼ぶクラス
package com.example.dailyadviceapp

class AdviceRepositoryImpl(
    private val api: AdviceApi    //api を受け取る
) : AdviceRepository {        // Interfaceを実装する
    override suspend fun getAdvice(): AdviceResponse {    //Interfaceで約束した getAdvice を実装します
        return api.getRandomAdvice()   //APIを呼ぶ
    }
}