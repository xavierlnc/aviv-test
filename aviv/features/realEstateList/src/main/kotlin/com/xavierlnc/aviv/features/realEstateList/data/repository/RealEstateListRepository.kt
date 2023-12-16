package com.xavierlnc.aviv.features.realEstateList.data.repository

import com.xavierlnc.aviv.features.realEstateList.domain.model.RealEstateModel

internal interface RealEstateListRepository {

    suspend fun getRealEstateList(): List<RealEstateModel>
}