package id.fatimazza.mymealapp.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://www.themealdb.com/api/json/"

/**
 * Use the Retrofit builder to build a retrofit object
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/**
 * Retrofit service object for creating api calls
 */
interface MealsApiService {
    @GET("v1/1/filter.php?a=Japanese")
    suspend fun getMeals(): String
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object MealsApi {
    val retrofitService: MealsApiService by lazy {
        retrofit.create(MealsApiService::class.java)
    }
}

