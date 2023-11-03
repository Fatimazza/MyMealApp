package id.fatimazza.mymealapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import id.fatimazza.mymealapp.model.MealResponse
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://www.themealdb.com/api/json/"

/**
 * Use the Retrofit builder to build a retrofit object
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

/**
 * Retrofit service object for creating api calls
 */
interface MealsApiService {
    @GET("v1/1/filter.php?a=Japanese")
    suspend fun getMeals(): MealResponse
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object MealsApi {
    val retrofitService: MealsApiService by lazy {
        retrofit.create(MealsApiService::class.java)
    }
}

