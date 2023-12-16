package com.xavierlnc.aviv.features.realEstateList.domain.model

internal data class RealEstateModel(
    val id: Int,
    val bedrooms: Int,
    val rooms: Int,
    val city: String,
    val area: Double,
    val imageUrl: String,
    val price: Double,
    val professional: String,
    val propertyType: String,
    val offerType: Int,
)