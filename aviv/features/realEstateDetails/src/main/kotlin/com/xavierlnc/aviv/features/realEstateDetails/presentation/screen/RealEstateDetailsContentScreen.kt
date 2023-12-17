package com.xavierlnc.aviv.features.realEstateDetails.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xavierlnc.designSystem.core.AsyncImage

@Composable
internal fun RealEstateDetailsContentScreen(
    price: String,
    type: String,
    details: String,
    location: String,
    imageUrl: String?,
    professional: String,
    offerType: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .scrollable(
                state = rememberScrollState(),
                orientation = Orientation.Vertical
            )
    ) {
        val horizontalPadding = Modifier.padding(horizontal = 12.dp)

        val imageContainerModifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
        imageUrl?.let {
            AsyncImage(
                modifier = imageContainerModifier,
                imageUrl = imageUrl,
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
        } ?: Box(modifier = imageContainerModifier.background(Color.LightGray))

        Spacer(modifier = modifier.height(24.dp))

        Text(
            modifier = horizontalPadding,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            text = type,
        )

        Spacer(modifier = modifier.height(12.dp))

        Text(
            modifier = horizontalPadding,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            text = details,
        )

        Spacer(modifier = modifier.height(8.dp))

        Text(
            modifier = horizontalPadding,
            fontSize = 14.sp,
            text = location,
        )

        Spacer(modifier = modifier.height(20.dp))

        Text(
            modifier = horizontalPadding,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            text = price,
        )
    }
}

@Preview
@Composable
private fun RealEstateDetailsContentScreenPreview() {
    RealEstateDetailsContentScreen(
        price = "1 500 000€",
        location = "Viliers-sur-Mer",
        details = "8 rooms - 4 bedrooms - 250 m2",
        type = "Maison - Villa",
        offerType = 1,
        professional = "GSL",
        imageUrl = null,
    )
}
