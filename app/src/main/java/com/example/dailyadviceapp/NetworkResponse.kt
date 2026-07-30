//APIの結果が成功したのか、失敗したのか、通信中なのか

package com.example.dailyadviceapp

sealed class NetworkResponse<T>(
    val data: T? =null,
    val error: String? = null,
){
    class Success<T>(data:T): NetworkResponse<T>(data = data)
    class Failure<T>(error: String) : NetworkResponse<T>(error = error)
    class Loading<T> : NetworkResponse<T>()
}
