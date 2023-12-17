package com.xavierlnc.aviv.features.realEstateDetails.presentation.model

internal data class RealEstateDetailsState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val id: Int = 0,
    val price: String = "",
    val type: String = "",
    val details: String = "",
    val location: String = "",
    val imageUrl: String? = null,
    val professional: String = "",
    val offerType: Int = 0,
)
