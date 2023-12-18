package com.xavierlnc.aviv.features.realEstateDetails.presentation.model

internal sealed interface RealEstateDetailsState {
    data object Loading : RealEstateDetailsState
    data object Error : RealEstateDetailsState
    data class Content(val details: RealEstateDetails) : RealEstateDetailsState
}
