package com.xavierlnc.aviv.features.realEstateDetails.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.xavierlnc.aviv.features.realEstateDetails.presentation.screen.RealEstateDetailsScreen

private const val ROUTE_ID_ARGUMENT = "PROPERTY_ID"

const val REAL_ESTATE_DETAILS_ROUTE = "real_estate_details_route/{$ROUTE_ID_ARGUMENT}"

fun NavController.navigateRealEstateDetails(
    id: Int,
    navOptions: NavOptions? = null
) {
    val formattedNavigationUrl =
        REAL_ESTATE_DETAILS_ROUTE.replace("{$ROUTE_ID_ARGUMENT}", id.toString())

    this.navigate(
        route = formattedNavigationUrl,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.realEstateDetailsScreen(
    onGoBack: () -> Unit,
) {
    composable(
        route = REAL_ESTATE_DETAILS_ROUTE,
        arguments = listOf(
            navArgument(ROUTE_ID_ARGUMENT) { type = NavType.IntType }
        )
    ) {
        val id = requireNotNull(it.arguments?.getInt(ROUTE_ID_ARGUMENT))

        RealEstateDetailsScreen(
            id = id,
            onGoBack = onGoBack,
        )
    }
}
