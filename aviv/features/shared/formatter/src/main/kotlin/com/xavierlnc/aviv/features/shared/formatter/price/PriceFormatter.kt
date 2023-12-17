package com.xavierlnc.aviv.features.shared.formatter.price

interface PriceFormatter {
    fun formatPrice(rawPrice: Double): String
}