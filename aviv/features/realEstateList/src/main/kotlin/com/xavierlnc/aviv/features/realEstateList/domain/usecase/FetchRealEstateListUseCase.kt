package com.xavierlnc.aviv.features.realEstateList.domain.usecase

import com.xavierlnc.aviv.features.realEstateList.domain.model.RealEstateModel
import javax.inject.Inject

internal interface FetchRealEstateListUseCase {
    suspend operator fun invoke(): FetchRealEstateListResult
}

internal sealed interface FetchRealEstateListResult {
    data object Error : FetchRealEstateListResult
    data class Success(val items: List<RealEstateModel>) : FetchRealEstateListResult
}

internal class FetchRealEstateListDefaultUseCase @Inject constructor() : FetchRealEstateListUseCase {
    override suspend fun invoke(): FetchRealEstateListResult {
        return FetchRealEstateListResult.Success(
            items = listOf(
                RealEstateModel(
                    bedrooms = 4,
                    city = "Villers-sur-Mer",
                    id = 1,
                    area = 250.0,
                    imageUrl = "https://v.seloger.com/s/crop/590x330/visuels/1/7/t/3/17t3fitclms3bzwv8qshbyzh9dw32e9l0p0udr80k.jpg",
                    price = 1500000.0,
                    professional = "GSL EXPLORE",
                    propertyType = "Maison - Villa",
                    offerType = 1,
                    rooms = 8
                ),
                RealEstateModel(
                    bedrooms = 7,
                    city = "Deauville",
                    id = 2,
                    area = 600.0,
                    imageUrl = "https//v.seloger.com/s/crop/590x330/visuels/2/a/l/s/2als8bgr8sd2vezcpsj988mse4olspi5rfzpadqok.jpg",
                    price = 3500000.0,
                    professional = "GSL STICKINESS",
                    propertyType = "Maison - Villa",
                    offerType = 2,
                    rooms = 11
                )
            )
        )
    }
}