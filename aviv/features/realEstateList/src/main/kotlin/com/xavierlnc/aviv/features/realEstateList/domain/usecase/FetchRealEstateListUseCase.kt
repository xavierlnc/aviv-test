package com.xavierlnc.aviv.features.realEstateList.domain.usecase

import com.xavierlnc.aviv.features.realEstateList.data.repository.RealEstateListRepository
import com.xavierlnc.aviv.features.realEstateList.domain.model.RealEstateModel
import javax.inject.Inject

internal interface FetchRealEstateListUseCase {
    suspend operator fun invoke(): FetchRealEstateListResult
}

internal sealed interface FetchRealEstateListResult {
    data object Error : FetchRealEstateListResult
    data class Success(val items: List<RealEstateModel>) : FetchRealEstateListResult
}

internal class FetchRealEstateListDefaultUseCase @Inject constructor(
    private val realEstateListRepository: RealEstateListRepository
) : FetchRealEstateListUseCase {
    override suspend fun invoke(): FetchRealEstateListResult =
        try {
            FetchRealEstateListResult.Success(items = realEstateListRepository.getRealEstateList())
        } catch (e: Exception) {
            FetchRealEstateListResult.Error
        }
}