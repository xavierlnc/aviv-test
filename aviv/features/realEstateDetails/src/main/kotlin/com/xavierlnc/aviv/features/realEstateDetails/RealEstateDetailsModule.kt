package com.xavierlnc.aviv.features.realEstateDetails

import android.content.Context
import com.xavierlnc.aviv.features.realEstateDetails.data.repository.RealEstateDetailsNetworkRepository
import com.xavierlnc.aviv.features.realEstateDetails.data.repository.RealEstateDetailsRepository
import com.xavierlnc.aviv.features.realEstateDetails.domain.usecase.FetchRealEstateDetailsDefaultUseCase
import com.xavierlnc.aviv.features.realEstateDetails.domain.usecase.FetchRealEstateDetailsUseCase
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsState
import com.xavierlnc.aviv.features.realEstateDetails.presentation.resources.RealEstateDetailsResources
import com.xavierlnc.network.realEstate.RealEstateService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
internal interface RealEstateDetailsModule {

    @Binds
    fun providesFetchRealEstateDetailsUseCase(
        fetchRealEstateDetailsDefaultUseCase: FetchRealEstateDetailsDefaultUseCase
    ): FetchRealEstateDetailsUseCase

    companion object {

        @Provides
        fun providesRealEstateDetailsState(): RealEstateDetailsState =
            RealEstateDetailsState.Loading

        @Provides
        fun providesRealEstateListResources(
            @ApplicationContext context: Context
        ): RealEstateDetailsResources = RealEstateDetailsResources(
            context = context
        )

        @Provides
        fun providesRealEstateDetailsRepository(
            realEstateService: RealEstateService,
        ): RealEstateDetailsRepository =
            RealEstateDetailsNetworkRepository(
                realEstateService = realEstateService
            )
    }
}