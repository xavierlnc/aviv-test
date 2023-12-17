package com.xavierlnc.aviv.features.realEstateDetails.presentation.model

internal sealed interface RealEstateDetailsEvent {
    data object GoBack : RealEstateDetailsEvent
}