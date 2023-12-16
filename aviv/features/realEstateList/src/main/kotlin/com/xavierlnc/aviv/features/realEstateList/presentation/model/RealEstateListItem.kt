package com.xavierlnc.aviv.features.realEstateList.presentation.model

internal data class RealEstateListItem(
    val id: Int,
    val price: String,
    val type: String,
    val details: String,
    val location: String,
    val imageUrl: String?,
)
