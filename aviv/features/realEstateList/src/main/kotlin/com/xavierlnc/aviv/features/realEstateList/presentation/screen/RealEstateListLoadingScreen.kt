package com.xavierlnc.aviv.features.realEstateList.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xavierlnc.designSystem.foundation.AvivTheme

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

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
private fun RealEstateListLoadingScreenPreview() = AvivTheme {
    RealEstateListLoadingScreen()
}