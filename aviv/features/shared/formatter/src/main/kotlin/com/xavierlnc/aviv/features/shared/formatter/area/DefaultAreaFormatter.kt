package com.xavierlnc.aviv.features.shared.formatter.area

import javax.inject.Inject

class DefaultAreaFormatter @Inject constructor() : AreaFormatter {

    /**
     * Given '250.0', then return '250 m²'
     */
    override fun formatArea(rawArea: Double): String {
        return rawArea.toInt().toString() + " m²"
    }
}