package com.xavierlnc.avivtest.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.xavierlnc.aviv.features.realEstateDetails.navigation.navigateRealEstateDetails
import com.xavierlnc.aviv.features.realEstateDetails.navigation.realEstateDetailsScreen
import com.xavierlnc.aviv.features.realEstateList.navigation.REAL_ESTATE_LIST_ROUTE
import com.xavierlnc.aviv.features.realEstateList.navigation.realEstateListScreen

@Composable
internal fun AvivRoot() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        AvivNavHost()
    }
}

@Composable
internal fun AvivNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = REAL_ESTATE_LIST_ROUTE,
    ) {
        realEstateListScreen(
            navigateToRealEstateDetails = { id ->
                navController.navigateRealEstateDetails(id = id)
            }
        )
        realEstateDetailsScreen(
            onGoBack = { navController.popBackStack() }
        )
    }
}