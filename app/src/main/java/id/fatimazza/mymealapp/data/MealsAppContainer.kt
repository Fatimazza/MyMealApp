package id.fatimazza.mymealapp.data

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import id.fatimazza.mymealapp.data.local.FavoriteMealsDatabase
import id.fatimazza.mymealapp.data.network.MealsApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * Dependency Injection container at the application level.
 */
interface MealsAppContainer {
    val mealsRepository: MealsRepository
    val favMealsRepository: FavMealsRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer(private val context: Context) : MealsAppContainer {

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

    /**
     * DI implementation for [MealsRepository]
     */
    override val mealsRepository: MealsRepository by lazy {
        NetworkMealsRepository(retrofitService)
    }
    override val favMealsRepository: FavMealsRepository by lazy {
        OfflineMealsRepository(
            FavoriteMealsDatabase.getDatabase(context).itemDao()
        )
    }
}

