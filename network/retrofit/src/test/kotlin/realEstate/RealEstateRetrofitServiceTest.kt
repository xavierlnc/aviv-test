package realEstate

import com.xavierlnc.network.realEstate.RealEstateServiceException
import com.xavierlnc.network.realEstate.model.RealEstateListItemEntity
import com.xavierlnc.network.retrofit.realEstate.RealEstateRetrofitService
import factory.RetrofitMockFactory
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class RealEstateRetrofitServiceTest {

    private lateinit var service: RealEstateRetrofitService

    private val mockWebServer = MockWebServer()

    @BeforeEach
    fun setUp() {
        mockWebServer.start()
        service = RealEstateRetrofitService(
            retrofit = RetrofitMockFactory(mockWebServer = mockWebServer).build(),
        )
    }

    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Nested
    inner class RealEstateListTest {

        @Test
        fun givenGetRealEstateList_whenSuccess_thenItShouldReturnContent() = runTest {
            mockWebServer.enqueue(
                MockResponse().setResponseCode(200).setBody(
                    """
                    {
                      "items": [{
                          "bedrooms": 4,
                          "city": "Villers-sur-Mer",
                          "id": 1,
                          "area": 250.0,
                          "url": "https://v.seloger.com/s/crop/590x330/visuels/1/7/t/3/17t3fitclms3bzwv8qshbyzh9dw32e9l0p0udr80k.jpg",
                          "price": 1500000.0,
                          "professional": "GSL EXPLORE",
                          "propertyType": "Maison - Villa",
                          "offerType": 1,
                          "rooms": 8
                      },
                      {
                          "bedrooms": 7,
                          "city": "Deauville",
                          "id": 2,
                          "area": 600.0,
                          "url": "https://v.seloger.com/s/crop/590x330/visuels/2/a/l/s/2als8bgr8sd2vezcpsj988mse4olspi5rfzpadqok.jpg",
                          "price": 3500000.0,
                          "professional": "GSL STICKINESS",
                          "propertyType": "Maison - Villa",
                          "offerType": 2,
                          "rooms": 11
                      },
                      {
                          "city": "Bordeaux",
                          "id": 3,
                          "area": 550.0,
                          "price": 3000000.0,
                          "professional": "GSL OWNERS",
                          "propertyType": "Maison - Villa",
                          "offerType": 1,
                          "rooms": 7
                      },
                      {
                          "city": "Nice",
                          "id": 4,
                          "area": 250.0,
                          "url": "https://v.seloger.com/s/crop/590x330/visuels/1/9/f/x/19fx7n4og970dhf186925d7lrxv0djttlj5k9dbv8.jpg",
                          "price": 5000000.0,
                          "professional": "GSL CONTACTING",
                          "offerType": 3,  
                          "propertyType": "Maison - Villa"
                      }],
                      "totalCount": 4
                    }
                    """.trimIndent()
                )
            )

            val result = service.getRealEstateList()

            Assertions.assertEquals(
                listOf(
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
                ),
                result
            )

            mockWebServer.takeRequest().apply {
                Assertions.assertEquals("GET", method)
                Assertions.assertEquals("/listings.json", path)
            }
        }

        @Test
        fun givenGetRealEstateList_whenSuccess_thenItShouldReturnEmptyList() = runTest {
            mockWebServer.enqueue(
                MockResponse().setResponseCode(200).setBody(
                    """
                    {
                      "items": [],
                      "totalCount": 0
                    }
                    """.trimIndent()
                )
            )

            val result = service.getRealEstateList()

            Assertions.assertEquals(
                emptyList<RealEstateListItemEntity>(),
                result
            )

            mockWebServer.takeRequest().apply {
                Assertions.assertEquals("GET", method)
                Assertions.assertEquals("/listings.json", path)
            }
        }

        @Test
        fun givenGetRealEstateList_whenSuccess_thenItShouldReturnError() = runTest {
            mockWebServer.enqueue(
                MockResponse().setResponseCode(400)
            )

            assertThrows<RealEstateServiceException> { service.getRealEstateList() }

            mockWebServer.takeRequest().apply {
                Assertions.assertEquals("GET", method)
                Assertions.assertEquals("/listings.json", path)
            }
        }
    }
}