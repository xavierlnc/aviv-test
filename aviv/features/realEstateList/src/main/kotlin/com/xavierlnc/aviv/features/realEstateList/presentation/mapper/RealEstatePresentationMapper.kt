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
            details = "${item.rooms} rooms • ${item.bedrooms} bedrooms • ${item.area.mapAreaToPresentation()}",
            price = item.price.mapPriceToPresentation(),
        )

    private fun Double.mapPriceToPresentation(): String = "${this.toInt()} €"

    private fun Double.mapAreaToPresentation(): String = "${this.toInt()} m²"
}