package com.xavierlnc.aviv.features.realEstateDetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RealEstateDetailsViewModel @Inject constructor(
    initialState: RealEstateDetailsState,
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
        // TODO
    }

    private fun onBackClicked() {
        viewModelScope.launch {
            eventFlow.emit(RealEstateDetailsEvent.GoBack)
        }
    }
}