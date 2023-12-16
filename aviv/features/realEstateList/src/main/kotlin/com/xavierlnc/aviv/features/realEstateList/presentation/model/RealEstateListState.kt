package com.xavierlnc.aviv.features.realEstateList.presentation.model

internal data class RealEstateListState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val isEmpty: Boolean = false,
    val estateList: List<RealEstateListItem> = listOf(),
)
