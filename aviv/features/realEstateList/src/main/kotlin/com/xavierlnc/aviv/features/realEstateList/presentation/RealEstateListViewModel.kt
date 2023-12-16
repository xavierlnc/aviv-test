package com.xavierlnc.aviv.features.realEstateList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListResult
import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListUseCase
import com.xavierlnc.aviv.features.realEstateList.presentation.mapper.RealEstatePresentationMapper
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListAction
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListItem
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RealEstateListViewModel @Inject constructor(
    initialState: RealEstateListState,
    private val fetchRealEstateListUseCase: FetchRealEstateListUseCase,
    private val realEstatePresentationMapper: RealEstatePresentationMapper,
) : ViewModel() {
    private val stateFlow: MutableStateFlow<RealEstateListState> = MutableStateFlow(initialState)

    val stateChanges: StateFlow<RealEstateListState> = stateFlow.asStateFlow()

    fun handleAction(action: RealEstateListAction) {
        when (action) {
            RealEstateListAction.FetchRealEstateList -> fetchEstateList()
            is RealEstateListAction.OnRealEstateItemClicked -> onEstateItemClicked(action.id)
        }
    }

    private fun fetchEstateList() {
        viewModelScope.launch {
            stateFlow.update { currentState ->
                currentState.copy(
                    isLoading = true,
                    isError = false,
                )
            }

            when (val fetchResult = fetchRealEstateListUseCase.invoke()) {
                FetchRealEstateListResult.Error -> {
                    stateFlow.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            isError = true,
                        )
                    }
                }
                is FetchRealEstateListResult.Success -> {
                    stateFlow.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            isError = false,
                            estateList = fetchResult.items.map {
                                realEstatePresentationMapper.mapRealEstateDomainToPresentation(it)
                            }
                        )
                    }
                }
            }
        }
    }

    private fun onEstateItemClicked(id: Int) {
        println("onEstateItemClicked $id")
    }
}