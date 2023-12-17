package com.xavierlnc.aviv.features.realEstateDetails.presentation.mapper

import com.xavierlnc.aviv.features.realEstateDetails.domain.model.RealEstateDetailsModel
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetails
import com.xavierlnc.aviv.features.shared.formatter.area.AreaFormatter
import com.xavierlnc.aviv.features.shared.formatter.price.PriceFormatter
import javax.inject.Inject

internal class RealEstateDetailsPresentationMapper @Inject constructor(
    private val priceFormatter: PriceFormatter,
    private val areaFormatter: AreaFormatter,
) {

    fun mapRealEstateDetailsDomainToPresentation(item: RealEstateDetailsModel): RealEstateDetails =
        RealEstateDetails(
            id = item.id,
            location = item.city,
            type = item.propertyType,
            imageUrl = item.imageUrl,
            details = createRealEstateCardDetails(
                rooms = item.rooms,
                bedrooms = item.bedrooms,
                area = item.area,
            ),
            price = priceFormatter.formatPrice(item.price),
            offerType = item.offerType,
            professional = item.professional,
        )

    private fun createRealEstateCardDetails(
        rooms: Int?,
        bedrooms: Int?,
        area: Double,
    ): String = listOfNotNull(
        rooms?.let { "$rooms rooms" },
        bedrooms?.let { "$bedrooms bedrooms" },
        areaFormatter.formatArea(area)
    ).joinToString(separator = " • ")
}
