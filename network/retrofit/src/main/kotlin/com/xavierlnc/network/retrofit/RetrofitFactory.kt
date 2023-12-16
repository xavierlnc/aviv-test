package com.xavierlnc.network.retrofit

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory(
    private val baseUrl: String,
) {
    fun build(): Retrofit =
        Retrofit
            .Builder()
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl(baseUrl)
            .build()

    private fun createHttpClient(): OkHttpClient = OkHttpClient.Builder().build()
}