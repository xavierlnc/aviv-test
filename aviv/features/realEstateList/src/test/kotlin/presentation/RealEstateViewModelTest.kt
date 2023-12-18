package presentation

import app.cash.turbine.testIn
import com.xavierlnc.aviv.features.realEstateList.domain.model.RealEstateModel
import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListResult
import com.xavierlnc.aviv.features.realEstateList.domain.usecase.FetchRealEstateListUseCase
import com.xavierlnc.aviv.features.realEstateList.presentation.RealEstateListViewModel
import com.xavierlnc.aviv.features.realEstateList.presentation.mapper.RealEstatePresentationMapper
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListAction
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListEvent
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListItem
import com.xavierlnc.aviv.features.realEstateList.presentation.model.RealEstateListState
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.Mockito.`when` as given

@ExtendWith(MockitoExtension::class)
class RealEstateViewModelTest {

    private lateinit var viewModel: RealEstateListViewModel

    @Mock
    private lateinit var fetchRealEstateListUseCase: FetchRealEstateListUseCase

    @Mock
    private lateinit var realEstatePresentationMapper: RealEstatePresentationMapper

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun createViewModel(
        initialState: RealEstateListState = RealEstateListState.Loading
    ): RealEstateListViewModel = RealEstateListViewModel(
        initialState = initialState,
        fetchRealEstateListUseCase = fetchRealEstateListUseCase,
        realEstatePresentationMapper = realEstatePresentationMapper,
        dispatcher = UnconfinedTestDispatcher(),
    )

    @Test
    fun givenFetchRealEstateListAction_whenFetching_thenItShouldReturnSuccess() = runTest {
        viewModel = createViewModel()

        val domainModels = listOf(
            RealEstateModel(
                bedrooms = 4,
                city = "Villers-sur-Mer",
                id = 1,
                area = 250.0,
                imageUrl = "https://v.seloger.com/s/crop/590x330/visuels/1/7/t/3/17t3fitclms3bzwv8qshbyzh9dw32e9l0p0udr80k.jpg",
                price = 1500000.0,
                professional = "GSL EXPLORE",
                propertyType = "Maison - Villa",
                offerType = 1,
                rooms = 8
            ),
            RealEstateModel(
                bedrooms = 7,
                city = "Deauville",
                id = 2,
                area = 600.0,
                imageUrl = "https://v.seloger.com/s/crop/590x330/visuels/2/a/l/s/2als8bgr8sd2vezcpsj988mse4olspi5rfzpadqok.jpg",
                price = 3500000.0,
                professional = "GSL STICKINESS",
                propertyType = "Maison - Villa",
                offerType = 2,
                rooms = 11
            ),
            RealEstateModel(
                city = "Bordeaux",
                id = 3,
                area = 550.0,
                price = 3000000.0,
                professional = "GSL OWNERS",
                propertyType = "Maison - Villa",
                offerType = 1,
                rooms = 7,
                bedrooms = null,
                imageUrl = null,
            ),
            RealEstateModel(
                city = "Nice",
                id = 4,
                area = 250.0,
                imageUrl = "https://v.seloger.com/s/crop/590x330/visuels/1/9/f/x/19fx7n4og970dhf186925d7lrxv0djttlj5k9dbv8.jpg",
                price = 5000000.0,
                professional = "GSL CONTACTING",
                offerType = 3,
                propertyType = "Maison - Villa",
                bedrooms = null,
                rooms = null,
            )
        )

        val presentationModels = listOf(
            RealEstateListItem(
                details = "8 rooms • 4 bedrooms • 250 m²",
                location = "Villers-sur-Mer",
                id = 1,
                imageUrl = "https://v.seloger.com/s/crop/590x330/visuels/1/7/t/3/17t3fitclms3bzwv8qshbyzh9dw32e9l0p0udr80k.jpg",
                price = "1 500 000 €",
                type = "Maison - Villa",
            ),
            RealEstateListItem(
                details = "11 rooms • 7 bedrooms • 600 m²",
                location = "Deauville",
                id = 2,
                imageUrl = "https://v.seloger.com/s/crop/590x330/visuels/2/a/l/s/2als8bgr8sd2vezcpsj988mse4olspi5rfzpadqok.jpg",
                price = "3 500 000 €",
                type = "Maison - Villa",
            ),
            RealEstateListItem(
                details = "7 rooms • 550 m²",
                location = "Bordeaux",
                id = 3,
                price = "3 000 000 €",
                type = "Maison - Villa",
                imageUrl = null,
            ),
            RealEstateListItem(
                details = "250 m²",
                location = "Nice",
                id = 4,
                imageUrl = "https://v.seloger.com/s/crop/590x330/visuels/1/9/f/x/19fx7n4og970dhf186925d7lrxv0djttlj5k9dbv8.jpg",
                price = "5 000 000 €",
                type = "Maison - Villa",
            )
        ).toImmutableList()

        given(fetchRealEstateListUseCase.invoke()).thenReturn(
            FetchRealEstateListResult.Success(
                items = domainModels
            )
        )

        given(realEstatePresentationMapper.mapRealEstateDomainToPresentation(domainModels))
            .thenReturn(presentationModels)

        viewModel.handleAction(RealEstateListAction.FetchRealEstateList)

        val state = viewModel.stateChanges.testIn(backgroundScope)

        Assertions.assertEquals(
            RealEstateListState.Content(estateList = presentationModels),
            state.awaitItem(),
        )
    }

    @Test
    fun givenFetchRealEstateListAction_whenFetching_thenItShouldReturnEmpty() = runTest {
        viewModel = createViewModel()

        given(fetchRealEstateListUseCase.invoke()).thenReturn(
            FetchRealEstateListResult.Success(items = listOf())
        )

        viewModel.handleAction(RealEstateListAction.FetchRealEstateList)

        val state = viewModel.stateChanges.testIn(backgroundScope)

        Assertions.assertEquals(
            RealEstateListState.Empty,
            state.awaitItem()
        )
    }


    @Test
    fun givenFetchRealEstateListAction_whenFetching_thenItShouldReturnError() = runTest {
        viewModel = createViewModel()

        given(fetchRealEstateListUseCase.invoke()).thenReturn(
            FetchRealEstateListResult.Error
        )

        viewModel.handleAction(RealEstateListAction.FetchRealEstateList)

        val state = viewModel.stateChanges.testIn(backgroundScope)

        Assertions.assertEquals(
            RealEstateListState.Error,
            state.awaitItem()
        )
    }


    @Test
    fun givenOnRealEstateItemClickedAction_thenItShouldSendEvent() = runTest {
        viewModel = createViewModel()

        val event = viewModel.eventChanges.testIn(backgroundScope)

        viewModel.handleAction(RealEstateListAction.OnRealEstateItemClicked(id = 1))


        Assertions.assertEquals(
            RealEstateListEvent.NavigateToRealEstateDetails(id = 1),
            event.awaitItem()
        )

        event.ensureAllEventsConsumed()
    }
}