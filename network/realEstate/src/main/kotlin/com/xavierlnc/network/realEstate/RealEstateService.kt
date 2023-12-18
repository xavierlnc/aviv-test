package com.xavierlnc.network.realEstate

import com.xavierlnc.network.realEstate.model.RealEstateDetailsEntity
import com.xavierlnc.network.realEstate.model.RealEstateListItemEntity

interface RealEstateService {
    suspend fun getRealEstateList(): List<RealEstateListItemEntity>
    suspend fun getRealEstateDetails(id: Int): RealEstateDetailsEntity
}

class RealEstateServiceException(
    message: String? = null,
    cause: Throwable? = null,
) : Throwable(message, cause)
