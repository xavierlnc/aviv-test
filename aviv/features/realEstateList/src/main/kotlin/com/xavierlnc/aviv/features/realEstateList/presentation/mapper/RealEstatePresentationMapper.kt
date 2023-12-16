package com.xavierlnc.aviv.features.realEstateList.presentation.mapper

import com.xavierlnc.aviv.features.realEstateList.domain.model.RealEstateModel
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListItem
import javax.inject.Inject

internal class RealEstatePresentationMapper @Inject constructor() {

    fun mapRealEstateDomainToPresentation(item: RealEstateModel): RealEstateListItem =
        RealEstateListItem(
            id = item.id,
            location = item.city,
            type = item.propertyType,
            imageUrl = item.imageUrl,
            details = createRealEstateCardDetails(
                rooms = item.rooms,
                bedrooms = item.bedrooms,
                area = item.area,
            ),
            price = item.price.mapPriceToPresentation(),
        )

    private fun createRealEstateCardDetails(
        rooms: Int?,
        bedrooms: Int?,
        area: Double,
    ): String = listOfNotNull(
        rooms?.let { "$rooms rooms" },
        bedrooms?.let { "$bedrooms bedrooms" },
        area.mapAreaToPresentation()
    ).joinToString(separator = " • ")

    private fun Double.mapPriceToPresentation(): String = "${this.toInt()} €"

    private fun Double.mapAreaToPresentation(): String = "${this.toInt()} m²"
}