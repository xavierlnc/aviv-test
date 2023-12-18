package com.xavierlnc.avivtest.di

import com.xavierlnc.network.retrofit.factory.RetrofitDefaultFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesRetrofit(): Retrofit =
        RetrofitDefaultFactory(
            baseUrl = "https://gsl-apps-technical-test.dignp.com",
        ).build()
}
