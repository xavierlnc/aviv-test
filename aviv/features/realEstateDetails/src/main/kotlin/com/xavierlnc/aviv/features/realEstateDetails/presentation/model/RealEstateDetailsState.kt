package com.xavierlnc.aviv.features.realEstateDetails.presentation.model

internal data class RealEstateDetailsState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val details: RealEstateDetails? = null,
)
