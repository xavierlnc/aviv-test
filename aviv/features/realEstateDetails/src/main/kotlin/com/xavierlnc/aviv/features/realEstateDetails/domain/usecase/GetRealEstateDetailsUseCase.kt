package com.xavierlnc.aviv.features.realEstateDetails.domain.usecase

import com.xavierlnc.aviv.features.realEstateDetails.data.repository.RealEstateDetailsRepository
import com.xavierlnc.aviv.features.realEstateDetails.domain.model.RealEstateDetailsModel
import javax.inject.Inject

internal interface FetchRealEstateDetailsUseCase {
    suspend operator fun invoke(id: Int): FetchRealEstateDetailsResult
}

internal sealed interface FetchRealEstateDetailsResult {
    data object Error : FetchRealEstateDetailsResult
    data class Success(val details: RealEstateDetailsModel) : FetchRealEstateDetailsResult
}

internal class FetchRealEstateDetailsDefaultUseCase @Inject constructor(
    private val realEstateDetailsRepository: RealEstateDetailsRepository
) : FetchRealEstateDetailsUseCase {
    override suspend fun invoke(id: Int): FetchRealEstateDetailsResult =
        try {
            FetchRealEstateDetailsResult.Success(
                details = realEstateDetailsRepository.getRealEstateDetails(id)
            )
        } catch (e: Exception) {
            FetchRealEstateDetailsResult.Error
        }
}