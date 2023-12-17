package com.xavierlnc.aviv.features.realEstateDetails

import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal interface RealEstateDetailsModule {

    companion object {

        @Provides
        fun providesRealEstateDetailsState(): RealEstateDetailsState = RealEstateDetailsState()
    }
}