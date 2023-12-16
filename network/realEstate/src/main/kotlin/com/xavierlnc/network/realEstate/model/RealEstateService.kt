package com.xavierlnc.network.realEstate.model

import com.xavierlnc.network.realEstate.model.list.RealEstateListItemEntity

interface RealEstateService {
    suspend fun getRealEstateList(): List<RealEstateListItemEntity>
}

class RealEstateServiceException(
    message: String? = null,
    cause: Throwable? = null,
) : Throwable(message, cause)
