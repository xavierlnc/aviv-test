package com.xavierlnc.aviv.features.realEstateDetails.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.xavierlnc.aviv.features.realEstateDetails.presentation.RealEstateDetailsViewModel
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsAction
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsEvent
import kotlinx.coroutines.flow.collect

@Composable
internal fun RealEstateDetailsScreen(
    id: Int,
    onGoBack: () -> Unit,
    viewModel: RealEstateDetailsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
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

    val state = viewModel.stateChanges

    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Details $id"
        )
    }
}