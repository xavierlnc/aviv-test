package com.xavierlnc.aviv.features.realEstateDetails.presentation.model

internal sealed interface RealEstateDetailsAction {
    data class FetchRealEstateDetails(val id: Int) : RealEstateDetailsAction
    data object OnBackClicked : RealEstateDetailsAction
}