package com.xavierlnc.aviv.features.realEstateList.presentation.model

internal sealed interface RealEstateListEvent {
    data class NavigateToRealEstateDetails(val id: Int) : RealEstateListEvent
}