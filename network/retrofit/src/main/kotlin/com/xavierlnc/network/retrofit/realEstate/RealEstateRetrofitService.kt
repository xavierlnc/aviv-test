package com.xavierlnc.network.retrofit.realEstate

import com.xavierlnc.network.realEstate.model.RealEstateService
import com.xavierlnc.network.realEstate.model.RealEstateServiceException
import com.xavierlnc.network.realEstate.model.list.RealEstateListItemEntity
import com.xavierlnc.network.retrofit.realEstate.list.RealEstateListJsonModel
import retrofit2.Retrofit
import retrofit2.http.GET

class RealEstateRetrofitService(
    private val retrofit: Retrofit,
) : RealEstateService {

    private val client: RealEstateClient by lazy {
        retrofit.create(RealEstateClient::class.java)
    }

    private interface RealEstateClient {
        @GET("/listings.json")
        suspend fun getRealEstateList(): RealEstateListJsonModel
    }

    override suspend fun getRealEstateList(): List<RealEstateListItemEntity> =
        try {
            val jsonModelResult = client.getRealEstateList()

            jsonModelResult.items.map {
                RealEstateListItemEntity(
                    price = it.price,
                    imageUrl = it.url,
                    rooms = it.rooms,
                    id = it.id,
                    propertyType = it.propertyType,
                    professional = it.professional,
                    offerType = it.offerType,
                    city = it.city,
                    bedrooms = it.bedrooms,
                    area = it.area,
                )
            }
        } catch (e: Exception) {
            throw RealEstateServiceException(
                cause = e.cause,
                message = e.message,
            )
        }
}