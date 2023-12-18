package com.xavierlnc.aviv.features.realEstateList.presentation.mapper

import com.xavierlnc.aviv.features.realEstateList.domain.model.RealEstateModel
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListItem
import com.xavierlnc.aviv.features.realEstateList.presentation.resources.RealEstateListResources
import com.xavierlnc.aviv.features.shared.formatter.area.AreaFormatter
import com.xavierlnc.aviv.features.shared.formatter.price.PriceFormatter
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

internal class RealEstatePresentationMapper @Inject constructor(
    private val priceFormatter: PriceFormatter,
    private val areaFormatter: AreaFormatter,
    private val realEstateListResources: RealEstateListResources,
) {

    fun mapRealEstateDomainToPresentation(items: List<RealEstateModel>): ImmutableList<RealEstateListItem> =
        items.map {  item ->
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
                price = priceFormatter.formatPrice(item.price),
            )
        }.toImmutableList()


    private fun createRealEstateCardDetails(
        rooms: Int?,
        bedrooms: Int?,
        area: Double,
    ): String = listOfNotNull(
        rooms?.let { realEstateListResources.formatRooms(it) },
        bedrooms?.let { realEstateListResources.formatBedrooms(it) },
        areaFormatter.formatArea(area)
    ).joinToString(separator = " • ")
}
