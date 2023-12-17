package com.xavierlnc.network.retrofit.realEstate

import com.google.gson.annotations.SerializedName

data class RealEstateListJsonModel(
    @SerializedName("items") val items: List<RealEstateListItemJsonModel>,
    @SerializedName("totalCount") val totalCount: Int,
)

data class RealEstateListItemJsonModel(
    @SerializedName("id") val id: Int,
    @SerializedName("bedrooms") val bedrooms: Int?,
    @SerializedName("rooms") val rooms: Int?,
    @SerializedName("city") val city: String,
    @SerializedName("area") val area: Double,
    @SerializedName("url") val url: String?,
    @SerializedName("price") val price: Double,
    @SerializedName("professional") val professional: String,
    @SerializedName("propertyType") val propertyType: String,
    @SerializedName("offerType") val offerType: Int,
)