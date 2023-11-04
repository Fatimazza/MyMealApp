package id.fatimazza.mymealapp.network

import id.fatimazza.mymealapp.model.DetailResponse
import id.fatimazza.mymealapp.model.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit service object for creating api calls
 */
interface MealsApiService {
    @GET("v1/1/filter.php?c=Beef")
    suspend fun getMeals(): MealsResponse

    @GET("v1/1/lookup.php")
    suspend fun getRecipeDetails(@Query("i") mealId: Int): DetailResponse
}

