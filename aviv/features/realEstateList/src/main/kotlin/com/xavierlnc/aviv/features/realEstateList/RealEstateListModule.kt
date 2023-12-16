package com.xavierlnc.aviv.features.realEstateList

import com.xavierlnc.aviv.features.realEstateList.data.repository.RealEstateListNetworkRepository
import com.xavierlnc.aviv.features.realEstateList.data.repository.RealEstateListRepository
import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListDefaultUseCase
import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListUseCase
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListState
import com.xavierlnc.network.retrofit.realEstate.RealEstateRetrofitService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
internal interface RealEstateListModule {

    @Binds
    fun providesFetchRealEstateListUseCase(
        fetchRealEstateListDefaultUseCase: FetchRealEstateListDefaultUseCase
    ): FetchRealEstateListUseCase

    companion object {
        @Provides
        fun providesRealEstateListState(): RealEstateListState = RealEstateListState()

        @Provides
        fun providesRealEstateListRepository(
            retrofit: Retrofit,
        ): RealEstateListRepository =
            RealEstateListNetworkRepository(
                realEstateService = RealEstateRetrofitService(
                    retrofit = retrofit,
                )
            )
    }
}