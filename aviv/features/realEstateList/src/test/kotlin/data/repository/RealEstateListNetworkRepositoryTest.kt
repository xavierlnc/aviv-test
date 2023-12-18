package data.repository

import com.xavierlnc.aviv.features.realEstateList.data.repository.RealEstateListNetworkRepository
import com.xavierlnc.aviv.features.realEstateList.data.repository.RealEstateListRepository
import com.xavierlnc.aviv.features.realEstateList.domain.model.RealEstateModel
import com.xavierlnc.network.realEstate.RealEstateService
import com.xavierlnc.network.realEstate.model.RealEstateListItemEntity
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.Mockito.`when` as given

@ExtendWith(MockitoExtension::class)
internal class RealEstateListNetworkRepositoryTest {

    private lateinit var repository: RealEstateListRepository

    @Mock
    private lateinit var realEstateService: RealEstateService

    @BeforeEach
    fun setUp() {
        repository = RealEstateListNetworkRepository(
            realEstateService = realEstateService
        )
    }

    @Test
    fun givenServiceResponse_whenMapping_thenItShouldReturnMappedData() = runTest {
        val entityModels = listOf(
            RealEstateListItemEntity(
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
            RealEstateListItemEntity(
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
            RealEstateListItemEntity(
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
            RealEstateListItemEntity(
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

        given(realEstateService.getRealEstateList()).thenReturn(entityModels)

        Assertions.assertEquals(
            domainModels,
            repository.getRealEstateList()
        )
    }
}