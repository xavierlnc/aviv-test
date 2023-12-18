package com.xavierlnc.aviv.features.realEstateList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListResult
import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListUseCase
import com.xavierlnc.aviv.features.realEstateList.presentation.mapper.RealEstatePresentationMapper
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListAction
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListEvent
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListState
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
internal class RealEstateListViewModel @Inject constructor(
    initialState: RealEstateListState,
    private val fetchRealEstateListUseCase: FetchRealEstateListUseCase,
    private val realEstatePresentationMapper: RealEstatePresentationMapper,
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val stateFlow: MutableStateFlow<RealEstateListState> = MutableStateFlow(initialState)
    private val eventFlow: MutableSharedFlow<RealEstateListEvent> = MutableSharedFlow()

    val stateChanges: StateFlow<RealEstateListState> = stateFlow.asStateFlow()
    val eventChanges: SharedFlow<RealEstateListEvent> = eventFlow.asSharedFlow()

    fun handleAction(action: RealEstateListAction) {
        when (action) {
            RealEstateListAction.FetchRealEstateList -> fetchEstateList()
            is RealEstateListAction.OnRealEstateItemClicked -> onEstateItemClicked(action.id)
        }
    }

    private fun fetchEstateList() {
        viewModelScope.launch(dispatcher) {
            stateFlow.update { RealEstateListState.Loading }

            when (val fetchResult = fetchRealEstateListUseCase.invoke()) {
                FetchRealEstateListResult.Error -> {
                    stateFlow.update { RealEstateListState.Error }
                }

                is FetchRealEstateListResult.Success -> {
                    if (fetchResult.items.isEmpty()) {
                        stateFlow.update { RealEstateListState.Empty }
                    } else {
                        stateFlow.update {
                            RealEstateListState.Content(
                                estateList = realEstatePresentationMapper.mapRealEstateDomainToPresentation(
                                    items = fetchResult.items,
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    private fun onEstateItemClicked(id: Int) {
        viewModelScope.launch(dispatcher) {
            eventFlow.emit(
                RealEstateListEvent.NavigateToRealEstateDetails(
                    id = id,
                )
            )
        }
    }
}