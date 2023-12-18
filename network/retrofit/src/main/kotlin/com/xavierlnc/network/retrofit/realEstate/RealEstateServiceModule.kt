package com.xavierlnc.network.retrofit.realEstate

import com.xavierlnc.network.realEstate.RealEstateService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RealEstateServiceModule {

    @Provides
    fun providesRealEstateService(
        retrofit: Retrofit,
    ): RealEstateService = RealEstateRetrofitService(
        retrofit = retrofit
    )
}