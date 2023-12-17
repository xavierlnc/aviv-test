package com.xavierlnc.aviv.features.realEstateDetails.data.repository

import com.xavierlnc.aviv.features.realEstateDetails.domain.model.RealEstateDetailsModel

internal interface RealEstateDetailsRepository {
    suspend fun getRealEstateDetails(id: Int): RealEstateDetailsModel
}