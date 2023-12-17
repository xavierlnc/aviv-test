package com.xavierlnc.aviv.features.realEstateList.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.xavierlnc.aviv.features.realEstateList.presentation.screen.RealEstateListScreen

const val REAL_ESTATE_LIST_ROUTE = "real_estate_list_route"

fun NavController.navigateRealEstateList(navOptions: NavOptions? = null) {
    this.navigate(
        route = REAL_ESTATE_LIST_ROUTE,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.realEstateListScreen(
    navigateToRealEstateDetails: (id: Int) -> Unit,
) {
    composable(route = REAL_ESTATE_LIST_ROUTE) {
        RealEstateListScreen(
            navigateToRealEstateDetails = navigateToRealEstateDetails,
        )
    }
}
