package com.xavierlnc.aviv.features.realEstateDetails.data.repository

import com.xavierlnc.aviv.features.realEstateDetails.domain.model.RealEstateDetailsModel
import com.xavierlnc.network.realEstate.model.RealEstateService
import javax.inject.Inject

internal class RealEstateDetailsNetworkRepository @Inject constructor(
    private val realEstateService: RealEstateService
) : RealEstateDetailsRepository {

    override suspend fun getRealEstateDetails(id: Int): RealEstateDetailsModel =
        realEstateService.getRealEstateDetails(id).let {  entity ->
            RealEstateDetailsModel(
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