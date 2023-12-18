package com.xavierlnc.aviv.features.realEstateList.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.xavierlnc.aviv.features.realEstateList.presentation.RealEstateListViewModel
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListAction
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListEvent
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListState

@Composable
internal fun RealEstateListScreen(
    navigateToRealEstateDetails: (id: Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RealEstateListViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.handleAction(RealEstateListAction.FetchRealEstateList)
    }

    LaunchedEffect(Unit) {
        viewModel.eventChanges.collect { event ->
            when (event) {
                is RealEstateListEvent.NavigateToRealEstateDetails -> navigateToRealEstateDetails(
                    event.id
                )
            }
        }
    }

    val state = viewModel.stateChanges.collectAsState().value

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {
        when (state) {
            is RealEstateListState.Content -> RealEstateListContentScreen(
                estateItems = state.estateList,
                onItemClicked = { id ->
                    viewModel.handleAction(RealEstateListAction.OnRealEstateItemClicked(id))
                }
            )

            RealEstateListState.Error -> RealEstateListErrorScreen(
                onTryAgainClicked = { viewModel.handleAction(RealEstateListAction.FetchRealEstateList) }
            )

            RealEstateListState.Empty -> RealEstateListEmptyScreen()
            RealEstateListState.Loading -> RealEstateListLoadingScreen()
        }
    }
}