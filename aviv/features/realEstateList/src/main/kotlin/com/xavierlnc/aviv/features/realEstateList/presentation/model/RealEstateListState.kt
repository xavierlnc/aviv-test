package com.xavierlnc.aviv.features.realEstateList.presentation.model

import kotlinx.collections.immutable.ImmutableList

internal sealed interface RealEstateListState {
    data object Loading : RealEstateListState
    data object Error : RealEstateListState
    data object Empty : RealEstateListState
    data class Content(val estateList: ImmutableList<RealEstateListItem>) : RealEstateListState
}
