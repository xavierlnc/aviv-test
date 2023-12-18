package factory

import com.google.gson.Gson
import com.xavierlnc.network.retrofit.factory.RetrofitFactory
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class RetrofitMockFactory(
    private val mockWebServer: MockWebServer,
) : RetrofitFactory {
    override fun build(): Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .baseUrl(mockWebServer.url("/"))
        .build()
}