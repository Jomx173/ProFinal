package com.example.clashroyale.data.client

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val API_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjVkNWE0MzA3LTI1ZWMtNDg0OC05ZjkxLTE0ZWVjYjEwMzNhMCIsImlhdCI6MTc2NTIyNjYzNCwic3ViIjoiZGV2ZWxvcGVyLzMwMjA5ZjM0LTU5MDItZWYzYy02M2JiLTNjM2M0ZWU1MTk3NCIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIxODEuMTE1LjUuMTE4Il0sInR5cGUiOiJjbGllbnQifV19.ZuE1Yxn_TQgXdyIsKWfX0omXclIwXFwTKXQB_dQcJcXj9A8d7iJX5llO2E9N4VoKcHcNIZhgVTLTwqNYnVwnjA"


    object NetworkConfig {
        const val BASE_URL = "https://api.clashroyale.com/v1/"
        const val TIMEOUT = 30L
    }


    private val tokenInterceptor = Interceptor { chain ->
        val newRequest = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer $API_TOKEN")
            .build()
        chain.proceed(newRequest)
    }

    private fun createOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .connectTimeout(NetworkConfig.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NetworkConfig.TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(NetworkConfig.TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(tokenInterceptor)
            .addInterceptor(logging)
            .build()
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(NetworkConfig.BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService = createRetrofit().create(ApiService::class.java)
}
