package com.xavierlnc.aviv.features.list.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel

@Composable
fun EstateListScreen(
    viewModel: EstateListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "List"
        )
    }
}