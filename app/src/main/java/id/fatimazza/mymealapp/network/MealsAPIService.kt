package id.fatimazza.mymealapp.network

import id.fatimazza.mymealapp.model.MealsResponse
import retrofit2.http.GET

/**
 * Retrofit service object for creating api calls
 */
interface MealsApiService {
    @GET("v1/1/filter.php?a=Japanese")
    suspend fun getMeals(): MealsResponse
}

