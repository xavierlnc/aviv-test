package com.xavierlnc.aviv.features.shared.formatter.price

import javax.inject.Inject

class DefaultPriceFormatter @Inject constructor() : PriceFormatter {

    /**
     * Given '1500000.0', then return '1 500 000 €'
     */
    override fun formatPrice(rawPrice: Double): String {
        val price = rawPrice.toInt().toString()

        var result = ""
        for (i in price.length - 1 downTo 0) {
            val nextChar = price[i]
            if (i % 3 == 0) {
                result += " $nextChar"
            } else {
                result += "$nextChar"
            }
        }

        return result.reversed().plus(" €")
    }
}