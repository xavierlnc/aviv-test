package com.xavierlnc.aviv.features.realEstateList.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xavierlnc.aviv.features.realEstateList.presentation.components.RealEstateCardComponent
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListItem
import com.xavierlnc.designSystem.foundation.AvivTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
internal fun RealEstateListContentScreen(
    estateItems: ImmutableList<RealEstateListItem>,
    onItemClicked: (id: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(
            horizontal = 12.dp,
            vertical = 24.dp,
        ),
        content = {
            items(
                items = estateItems,
                key = { it.id },
            ) {
                RealEstateCardComponent(
                    item = it,
                    onItemClicked = onItemClicked,
                )
            }
        }
    )
}


@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
private fun RealEstateListContentScreenPreview() = AvivTheme {
    RealEstateListContentScreen(
        onItemClicked = {},
        estateItems = listOf(
            RealEstateListItem(
                id = 0,
                price = "1 500 000€",
                location = "Viliers-sur-Mer",
                details = "8 rooms - 4 bedrooms - 250 m2",
                type = "Maison - Villa",
                imageUrl = null,
            ),
            RealEstateListItem(
                id = 1,
                price = "1 500 000€",
                location = "Viliers-sur-Mer",
                details = "8 rooms - 4 bedrooms - 250 m2",
                type = "Maison - Villa",
                imageUrl = null,
            ),
            RealEstateListItem(
                id = 2,
                price = "1 500 000€",
                location = "Viliers-sur-Mer",
                details = "8 rooms - 4 bedrooms - 250 m2",
                type = "Maison - Villa",
                imageUrl = null,
            ),
        ).toImmutableList()
    )
}