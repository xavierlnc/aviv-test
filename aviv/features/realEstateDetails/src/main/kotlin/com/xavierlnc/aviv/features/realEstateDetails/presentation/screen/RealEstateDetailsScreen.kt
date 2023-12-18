package com.xavierlnc.aviv.features.realEstateDetails.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.xavierlnc.aviv.features.realEstateDetails.presentation.RealEstateDetailsViewModel
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsAction
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsEvent
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsState

@Composable
internal fun RealEstateDetailsScreen(
    id: Int,
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RealEstateDetailsViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.handleAction(RealEstateDetailsAction.FetchRealEstateDetails(id))
    }

    LaunchedEffect(Unit) {
        viewModel.eventChanges.collect { event ->
            when (event) {
                RealEstateDetailsEvent.GoBack -> onGoBack()
            }
        }
    }

    val state = viewModel.stateChanges.collectAsState().value

    Box(modifier = modifier.fillMaxSize()) {
        when (state) {
            is RealEstateDetailsState.Content -> RealEstateDetailsContentScreen(
                details = state.details,
            )

            RealEstateDetailsState.Error -> RealEstateDetailsErrorScreen(
                onTryAgainClicked = {
                    viewModel.handleAction(RealEstateDetailsAction.FetchRealEstateDetails(id))
                }
            )

            RealEstateDetailsState.Loading -> RealEstateDetailsLoadingScreen()
        }
    }
}