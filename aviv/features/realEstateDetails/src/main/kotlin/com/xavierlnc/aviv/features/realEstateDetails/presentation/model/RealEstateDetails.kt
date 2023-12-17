package com.xavierlnc.aviv.features.realEstateDetails.presentation.model

internal data class RealEstateDetails(
    val id: Int,
    val price: String,
    val type: String,
    val details: String,
    val location: String,
    val imageUrl: String?,
    val professional: String,
    val offerType: Int,
)
