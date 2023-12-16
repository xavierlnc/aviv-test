package com.xavierlnc.aviv.features.realEstateList.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun RealEstateListErrorScreen(
    onTryAgainClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
   Box(
       modifier = modifier.fillMaxSize(),
       contentAlignment = Alignment.Center,
   ) {
       Text(text = "Something went wrong, please try again")
       Button(onClick = onTryAgainClicked) {
           Text(text = "Try again")
       }
   }
}