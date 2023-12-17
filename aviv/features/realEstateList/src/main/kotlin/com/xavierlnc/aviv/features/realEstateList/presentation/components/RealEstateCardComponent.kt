package com.xavierlnc.aviv.features.realEstateList.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListItem
import com.xavierlnc.designSystem.core.AsyncImage

@Composable
internal fun RealEstateCardComponent(
    item: RealEstateListItem,
    onItemClicked: (id: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .background(color = Color.Transparent)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                onClick = { onItemClicked(item.id) }
            ),
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(4.dp),
    ) {
        Column {
            val imageBoxModifier = Modifier
                .fillMaxWidth()
                .height(200.dp)

            item.imageUrl?.let { url ->
                AsyncImage(
                    modifier = imageBoxModifier,
                    imageUrl = url,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
            } ?: Box(
                modifier = imageBoxModifier
                    .background(color = Color.Gray)
            )

            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = item.price,
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    text = item.type,
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    text = item.details,
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    fontSize = 16.sp,
                    text = item.location,
                )
            }
        }
    }
}

@Preview
@Composable
private fun EstateCardPreview() {
    RealEstateCardComponent(
        item = RealEstateListItem(
            details = "8 rooms - 4 bedrooms - 250 m²",
            type = "Maison - Villa",
            location = "Villers-sur-Mer",
            id = 1,
            price = "1 500 000 €",
            imageUrl = null,
        ),
        onItemClicked = {},
    )
}