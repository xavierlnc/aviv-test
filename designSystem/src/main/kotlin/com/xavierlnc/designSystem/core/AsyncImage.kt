package com.xavierlnc.designSystem.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AsyncImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    contentDescription: String? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    usePlaceHolder: Boolean = true,
) {
    GlideImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
    ) {
        it
        /* TODO FIX ME
        if (usePlaceHolder) {
            it.placeholder(R.drawable.image_placeholder)
        } else {
            it
        }
         */
    }
}
