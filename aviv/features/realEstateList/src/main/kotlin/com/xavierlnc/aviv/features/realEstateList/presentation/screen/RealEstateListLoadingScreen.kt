package com.xavierlnc.aviv.features.realEstateList.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun RealEstateListLoadingScreen(
    modifier: Modifier = Modifier,
) {
   Box(
       modifier = modifier.fillMaxSize(),
       contentAlignment = Alignment.Center,
   ) {
       CircularProgressIndicator()
   }
}