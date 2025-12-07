package com.example.clashroyale.data.client

import com.example.clashroyale.data.api.NetworkConfig
import com.example.clashroyale.data.client.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiClient {

    private const val API_TOKEN =
        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImE2ZTViYWQ5LWMyZDUtNDQ2OS1hNDc2LTgyMjFlMzdjMGNmZSIsImlhdCI6MTc2NTEyNzAzOSwic3ViIjoiZGV2ZWxvcGVyL2RkOTg0NmVmLWM5MGMtMzFkYi0wNTcyLTYwYzQ2YTZjYWFjMiIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyI0NS4xNzAuMzIuNDEiXSwidHlwZSI6ImNsaWVudCJ9XX0.9fXgPJn_jnlR2btZJ2SWVzae1-FEe91tOE_Y2g0fwCd4W7VcNTovodb9N1tFkWsnT5J_y4clrda14Y8ZHUmrWA"

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


