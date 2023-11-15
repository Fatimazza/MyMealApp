package id.fatimazza.mymealapp.ui.fake

import id.fatimazza.mymealapp.data.model.DetailResponse
import id.fatimazza.mymealapp.data.model.MealsResponse
import id.fatimazza.mymealapp.data.network.MealsApiService

class MealsFakeApiService : MealsApiService {
    override suspend fun getMeals(): MealsResponse {
        return MealsFakeDataSource.mealsList
    }

    override suspend fun getRecipeDetails(mealId: Int): DetailResponse {
        return MealsFakeDataSource.mealDetailList
    }
}
