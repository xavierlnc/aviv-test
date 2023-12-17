package com.xavierlnc.network.realEstate.model

interface RealEstateService {
    suspend fun getRealEstateList(): List<RealEstateListItemEntity>
    suspend fun getRealEstateDetails(id: Int): RealEstateDetailsEntity
}

class RealEstateServiceException(
    message: String? = null,
    cause: Throwable? = null,
) : Throwable(message, cause)
