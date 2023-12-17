package com.xavierlnc.network.retrofit.realEstate

import com.xavierlnc.network.realEstate.model.RealEstateDetailsEntity
import com.xavierlnc.network.realEstate.model.RealEstateListItemEntity
import com.xavierlnc.network.realEstate.model.RealEstateService
import com.xavierlnc.network.realEstate.model.RealEstateServiceException
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

class RealEstateRetrofitService(
    private val retrofit: Retrofit,
) : RealEstateService {

    private val client: RealEstateClient by lazy {
        retrofit.create(RealEstateClient::class.java)
    }

    private interface RealEstateClient {
        @GET("/listings.json")
        suspend fun getRealEstateList(): RealEstateListJsonModel

        @GET("/listings/{id}.json")
        suspend fun getRealEstateDetails(
            @Path("id") id: Int
        ): RealEstateItemJsonModel
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

    override suspend fun getRealEstateDetails(id: Int): RealEstateDetailsEntity =
        try {
            val jsonModelResult = client.getRealEstateDetails(id)

            jsonModelResult.let {
                RealEstateDetailsEntity(
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