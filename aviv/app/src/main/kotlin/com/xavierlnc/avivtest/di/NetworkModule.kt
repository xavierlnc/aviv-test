package com.xavierlnc.avivtest.di

import android.content.Context
import com.xavierlnc.network.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesRetrofit(
        @ApplicationContext context: Context,
    ): Retrofit =
        RetrofitFactory(
            baseUrl = "https://gsl-apps-technical-test.dignp.com",
        ).build()
}
