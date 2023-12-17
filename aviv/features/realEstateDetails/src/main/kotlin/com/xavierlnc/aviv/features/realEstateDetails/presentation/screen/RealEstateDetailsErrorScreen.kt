package com.xavierlnc.aviv.features.realEstateDetails.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xavierlnc.designSystem.foundation.AvivTheme

@Composable
internal fun RealEstateDetailsErrorScreen(
    onTryAgainClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Something went wrong, please try again")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onTryAgainClicked) {
            Text(text = "Try again")
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
private fun RealEstateDetailsErrorScreenPreview() = AvivTheme {
    RealEstateDetailsErrorScreen(
        onTryAgainClicked = {},
    )
}