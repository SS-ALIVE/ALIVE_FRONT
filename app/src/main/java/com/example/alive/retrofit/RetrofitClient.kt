
package com.example.alive.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "http://114.70.21.242:8080/"

    val userService: UserService by lazy {
        val client = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS) // 연결 타임아웃 설정
            .readTimeout(60, TimeUnit.SECONDS) // 읽기 타임아웃 설정
            .writeTimeout(60, TimeUnit.SECONDS) // 쓰기 타임아웃 설정
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()



        retrofit.create(UserService::class.java)
    }
}

