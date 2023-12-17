package com.xavierlnc.aviv.features.realEstateDetails.domain.model

internal data class RealEstateDetailsModel(
    val id: Int,
    val bedrooms: Int?,
    val rooms: Int?,
    val city: String,
    val area: Double,
    val imageUrl: String?,
    val price: Double,
    val professional: String,
    val propertyType: String,
    val offerType: Int,
)