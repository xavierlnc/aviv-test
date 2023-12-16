package com.xavierlnc.aviv.features.realEstateList.presentation.model

internal sealed interface RealEstateListAction {
    data object FetchRealEstateList : RealEstateListAction
    data class OnRealEstateItemClicked(val id: Int) : RealEstateListAction
}