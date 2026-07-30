//BASE_URLとAdviceApiをつなぐ。Retrofit
package com.example.dailyadviceapp

import com.example.dailyadviceapp.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
@InstallIn(SingletonComponent::class)//この Module をアプリ全体で使えるようにする,SingletonComponentはAdviceApi を1個だけ作る

object AppModule {
    @Provides
    @Singleton
    fun provideAdviceApi(): AdviceApi {
        return Retrofit.Builder()// Retrofit作成開始。Retrofitを初期化。
            .baseUrl(BASE_URL)//テンプレ↓
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(AdviceApi::class.java)//↑

    }
    //AdviceRepository の作り方を Hilt に教えている
    @Provides
    @Singleton
    fun provideAdviceRepository(
        api: AdviceApi
    ): AdviceRepository {
        return AdviceRepositoryImpl(api)
    }
}