package com.xavierlnc.network.retrofit.factory

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitDefaultFactory(
    private val baseUrl: String,
) : RetrofitFactory {
    override fun build(): Retrofit =
        Retrofit
            .Builder()
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl(baseUrl)
            .build()

    private fun createHttpClient(): OkHttpClient = OkHttpClient.Builder().build()
}