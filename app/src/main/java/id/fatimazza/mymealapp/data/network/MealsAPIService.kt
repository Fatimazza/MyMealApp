package id.fatimazza.mymealapp.data.network

import id.fatimazza.mymealapp.data.model.DetailResponse
import id.fatimazza.mymealapp.data.model.MealsResponse
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

