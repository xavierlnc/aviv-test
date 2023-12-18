package com.xavierlnc.aviv.features.realEstateDetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xavierlnc.aviv.features.realEstateDetails.domain.usecase.FetchRealEstateDetailsResult
import com.xavierlnc.aviv.features.realEstateDetails.domain.usecase.FetchRealEstateDetailsUseCase
import com.xavierlnc.aviv.features.realEstateDetails.presentation.mapper.RealEstateDetailsPresentationMapper
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsAction
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsEvent
import com.xavierlnc.aviv.features.realEstateDetails.presentation.model.RealEstateDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
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
    private val mapper: RealEstateDetailsPresentationMapper,
    private val dispatcher: CoroutineDispatcher,
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
        stateFlow.update { RealEstateDetailsState.Loading }

        viewModelScope.launch(dispatcher) {
            when (val result = fetchRealEstateDetailsUseCase.invoke(id)) {
                FetchRealEstateDetailsResult.Error -> {
                    stateFlow.update { RealEstateDetailsState.Error }
                }

                is FetchRealEstateDetailsResult.Success -> {
                    stateFlow.update {
                        RealEstateDetailsState.Content(
                            details = mapper.mapRealEstateDetailsDomainToPresentation(
                                item = result.details
                            ),
                        )
                    }
                }
            }
        }
    }

    private fun onBackClicked() {
        viewModelScope.launch(dispatcher) {
            eventFlow.emit(RealEstateDetailsEvent.GoBack)
        }
    }
}