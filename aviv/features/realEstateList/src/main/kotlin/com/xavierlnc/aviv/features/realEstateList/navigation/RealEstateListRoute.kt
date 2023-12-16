package com.xavierlnc.aviv.features.realEstateList.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.xavierlnc.aviv.features.realEstateList.presentation.screen.RealEstateListScreen

const val ESTATE_LIST_ROUTE = "estate_list_route"

fun NavController.navigateRealEstateList(navOptions: NavOptions? = null) {
    this.navigate(
        route = ESTATE_LIST_ROUTE,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.realEstateListScreen() {
    composable(route = ESTATE_LIST_ROUTE) {
        RealEstateListScreen()
    }
}
