package com.example.mobg5_53203.screen.apiWifi


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * A constant string that defines the base URL for the API.
 */
private const val BASE_URL = "https://opendata.brussels.be/api/records/1.0/search/"

/**
 * A Moshi object that is used to parse JSON data.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * A Retrofit object that is used to create RESTful API services using an interface.
 * The Retrofit object uses a MoshiConverterFactory to convert JSON data to Kotlin objects and vice versa.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * An interface that defines a suspendable API function called getProperties.
 * The function uses the @GET annotation to indicate that it performs an HTTP GET request to the specified URL.
 * The function returns a WifiProperty object.
 */
interface WifiApiService {

    @GET("?dataset=bruxelles_wifi&q=&rows=212")
    suspend fun getProperties():
            WifiProperty
}
/**
 * An object that defines a retrofitService property, which is an instance of the WifiApiService interface.
    The instance is created in a lazy manner using the create method of the retrofit object.
    This means that the WifiApiService instance will only be created
    when it is first used, rather than when the WifiApi object is instantiated.
 *
 */
object WifiApi {
    val retrofitService : WifiApiService by lazy {
        retrofit.create(WifiApiService::class.java) }
}