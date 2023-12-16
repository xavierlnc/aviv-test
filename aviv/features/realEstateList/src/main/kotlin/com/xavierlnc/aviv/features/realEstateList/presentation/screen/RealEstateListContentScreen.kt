package com.xavierlnc.aviv.features.realEstateList.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xavierlnc.aviv.features.realEstateList.presentation.components.RealEstateCardComponent
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListItem

@Composable
internal fun RealEstateListContentScreen(
    estateItems: List<RealEstateListItem>,
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
