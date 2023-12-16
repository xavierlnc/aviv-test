package com.xavierlnc.aviv.features.realEstateList

import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListDefaultUseCase
import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListUseCase
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListState
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

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
    }
}