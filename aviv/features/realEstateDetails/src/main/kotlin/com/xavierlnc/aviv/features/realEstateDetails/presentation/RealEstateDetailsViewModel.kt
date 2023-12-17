package com.xavierlnc.aviv.features.realEstateDetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xavierlnc.aviv.features.realEstateDetails.domain.model.RealEstateDetailsModel
import com.xavierlnc.aviv.features.realEstateDetails.domain.usecase.FetchRealEstateDetailsResult
import com.xavierlnc.aviv.features.realEstateDetails.domain.usecase.FetchRealEstateDetailsUseCase
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsAction
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsEvent
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RealEstateDetailsViewModel @Inject constructor(
    initialState: RealEstateDetailsState,
    private val fetchRealEstateDetailsUseCase: FetchRealEstateDetailsUseCase,
) : ViewModel() {
    private val stateFlow: MutableStateFlow<RealEstateDetailsState> = MutableStateFlow(initialState)
    private val eventFlow: MutableSharedFlow<RealEstateDetailsEvent> = MutableSharedFlow()

    val stateChanges: StateFlow<RealEstateDetailsState> = stateFlow.asStateFlow()
    val eventChanges: SharedFlow<RealEstateDetailsEvent> = eventFlow.asSharedFlow()

    fun handleAction(action: RealEstateDetailsAction) {
        when (action) {
            is RealEstateDetailsAction.FetchRealEstateDetails -> fetchRealEstateDetails(action.id)
            RealEstateDetailsAction.OnBackClicked -> onBackClicked()
        }
    }

    private fun fetchRealEstateDetails(id: Int) {
        stateFlow.update { currentState ->
            currentState.copy(
                isLoading = true,
                isError = false,
            )
        }

        viewModelScope.launch {
            when (val result = fetchRealEstateDetailsUseCase.invoke(id)) {
                FetchRealEstateDetailsResult.Error -> {
                    stateFlow.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            isError = true,
                        )
                    }
                }
                is FetchRealEstateDetailsResult.Success -> {
                    stateFlow.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            isError = false,
                            details =  createRealEstateCardDetails(
                                area = result.details.area,
                                rooms = result.details.rooms,
                                bedrooms = result.details.bedrooms,
                            ),
                            imageUrl = result.details.imageUrl,
                            price = result.details.price.mapPriceToPresentation(),
                            professional = result.details.professional,
                            offerType = result.details.offerType,
                            type = result.details.propertyType,
                            location = result.details.city,
                            id = result.details.id,
                        )
                    }
                }
            }
        }
    }

    private fun createRealEstateCardDetails(
        rooms: Int?,
        bedrooms: Int?,
        area: Double,
    ): String = listOfNotNull(
        rooms?.let { "$rooms rooms" },
        bedrooms?.let { "$bedrooms bedrooms" },
        area.mapAreaToPresentation()
    ).joinToString(separator = " • ")

    private fun Double.mapPriceToPresentation(): String = "${this.toInt()} €"

    private fun Double.mapAreaToPresentation(): String = "${this.toInt()} m²"

    private fun onBackClicked() {
        viewModelScope.launch {
            eventFlow.emit(RealEstateDetailsEvent.GoBack)
        }
    }
}