package org.d3ifcool.yummytime.utils.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }

    fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(provideOKHTTP())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideOKHTTP(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(provideLoggingInterceptor())
        .build()

    private fun provideLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().apply {
            HttpLoggingInterceptor().level = HttpLoggingInterceptor.Level.BODY
        }
}