package com.xavierlnc.aviv.features.shared.formatter

import com.xavierlnc.aviv.features.shared.formatter.area.AreaFormatter
import com.xavierlnc.aviv.features.shared.formatter.area.DefaultAreaFormatter
import com.xavierlnc.aviv.features.shared.formatter.price.DefaultPriceFormatter
import com.xavierlnc.aviv.features.shared.formatter.price.PriceFormatter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface FormatterModule {
    @Binds
    fun providesAreaFormatter(
        defaultAreaFormatter: DefaultAreaFormatter
    ): AreaFormatter

    @Binds
    fun providesPriceFormatter(
        defaultPriceFormatter: DefaultPriceFormatter
    ): PriceFormatter
}