package com.xavierlnc.network.retrofit.factory

import retrofit2.Retrofit

interface RetrofitFactory {
    fun build(): Retrofit
}