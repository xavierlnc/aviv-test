package com.xavierlnc.aviv.features.estateList.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.xavierlnc.aviv.features.estateList.presentation.EstateListScreen

const val ESTATE_LIST_ROUTE = "estate_list_route"

fun NavController.navigateEstateList(navOptions: NavOptions? = null) {
    this.navigate(
        route = ESTATE_LIST_ROUTE,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.estateListScreen() {
    composable(route = ESTATE_LIST_ROUTE) {
        EstateListScreen()
    }
}
