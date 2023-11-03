package id.fatimazza.mymealapp.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import id.fatimazza.mymealapp.network.MealsApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * Dependency Injection container at the application level.
 */
interface MealsAppContainer {
    val mealsRepository: MealsRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : MealsAppContainer {

    private val BASE_URL =
        "https://www.themealdb.com/api/json/"

    /**
     * Use the Retrofit builder to build a retrofit object
     */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    /**
     * A public Api object that exposes the lazy-initialized Retrofit service
     */
    private val retrofitService: MealsApiService by lazy {
            retrofit.create(MealsApiService::class.java)
        }

    override val mealsRepository: MealsRepository
        get() = TODO("Not yet implemented")

}

