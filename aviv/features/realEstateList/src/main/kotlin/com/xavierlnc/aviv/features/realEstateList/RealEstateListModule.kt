package com.xavierlnc.aviv.features.realEstateList

import android.content.Context
import com.xavierlnc.aviv.features.realEstateList.data.repository.RealEstateListNetworkRepository
import com.xavierlnc.aviv.features.realEstateList.data.repository.RealEstateListRepository
import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListDefaultUseCase
import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListUseCase
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListState
import com.xavierlnc.aviv.features.realEstateList.presentation.resources.RealEstateListResources
import com.xavierlnc.network.realEstate.RealEstateService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
internal interface RealEstateListModule {

    @Binds
    fun providesFetchRealEstateListUseCase(
        fetchRealEstateListDefaultUseCase: FetchRealEstateListDefaultUseCase
    ): FetchRealEstateListUseCase

    companion object {
        @Provides
        fun providesRealEstateListState(): RealEstateListState = RealEstateListState.Loading

        @Provides
        fun providesRealEstateListResources(
            @ApplicationContext context: Context
        ): RealEstateListResources = RealEstateListResources(
            context = context
        )

        @Provides
        fun providesRealEstateListRepository(
            realEstateService: RealEstateService
        ): RealEstateListRepository =
            RealEstateListNetworkRepository(
                realEstateService = realEstateService
            )
    }
}