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

@Composable
internal fun RealEstateListScreen(
    viewModel: RealEstateListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(Unit) {
        viewModel.handleAction(RealEstateListAction.FetchRealEstateList)
    }

    val state = viewModel.stateChanges.collectAsState()

    Box(
        modifier = modifier.fillMaxSize().background(color = Color.White),
    ) {

        when {
            state.value.isLoading -> RealEstateListLoadingScreen()

            state.value.isError -> RealEstateListErrorScreen(
                onTryAgainClicked = { viewModel.handleAction(RealEstateListAction.FetchRealEstateList) }
            )

            state.value.isEmpty -> RealEstateListEmptyScreen()

            else -> RealEstateListContentScreen(
                estateItems = state.value.estateList,
                onItemClicked = { id ->
                    viewModel.handleAction(RealEstateListAction.OnRealEstateItemClicked(id))
                }
            )
        }
    }
}