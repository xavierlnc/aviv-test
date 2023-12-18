package com.xavierlnc.aviv.features.realEstateList.data.repository

import com.xavierlnc.aviv.features.realEstateList.domain.model.RealEstateModel
import com.xavierlnc.network.realEstate.RealEstateService
import javax.inject.Inject

internal class RealEstateListNetworkRepository @Inject constructor(
    private val realEstateService: RealEstateService,
): RealEstateListRepository {
    override suspend fun getRealEstateList(): List<RealEstateModel> =
        realEstateService.getRealEstateList().map { entity ->
            RealEstateModel(
                id =  entity.id,
                area = entity.area,
                bedrooms = entity.bedrooms,
                city = entity.city,
                offerType = entity.offerType,
                professional = entity.professional,
                propertyType = entity.propertyType,
                rooms = entity.rooms,
                imageUrl = entity.imageUrl,
                price = entity.price,
            )
        }
}