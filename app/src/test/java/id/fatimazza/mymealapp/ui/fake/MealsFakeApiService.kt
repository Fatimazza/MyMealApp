package id.fatimazza.mymealapp.ui.fake

import id.fatimazza.mymealapp.model.MealsItem
import id.fatimazza.mymealapp.model.MealsResponse
import id.fatimazza.mymealapp.network.MealsApiService

class MealsFakeApiService : MealsApiService {
    override suspend fun getMeals(): MealsResponse {
        return MealsFakeDataSource.mealsList
    }
}
