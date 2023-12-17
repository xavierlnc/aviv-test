package com.xavierlnc.aviv.features.realEstateDetails.presentation.resources

import android.content.Context

import com.xavierlnc.aviv.features.shared.common.R
import javax.inject.Inject

class RealEstateDetailsResources @Inject constructor(
    context: Context
) {

    private val resources = context.resources

    fun formatBedrooms(count: Int): String = resources.getQuantityString(
        R.plurals.common_bedrooms,
        count,
        count,
    )

    fun formatRooms(count: Int): String = resources.getQuantityString(
        R.plurals.common_rooms,
        count,
        count,
    )
}