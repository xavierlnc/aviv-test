package com.xavierlnc.avivtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.xavierlnc.aviv.features.realEstateDetails.navigation.navigateRealEstateDetails
import com.xavierlnc.aviv.features.realEstateDetails.navigation.realEstateDetailsScreen
import com.xavierlnc.aviv.features.realEstateList.navigation.REAL_ESTATE_LIST_ROUTE
import com.xavierlnc.aviv.features.realEstateList.navigation.realEstateListScreen
import com.xavierlnc.avivtest.navigation.AvivRoot
import com.xavierlnc.designSystem.foundation.AvivTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AvivActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvivTheme {
                AvivRoot()
            }
        }
    }
}
