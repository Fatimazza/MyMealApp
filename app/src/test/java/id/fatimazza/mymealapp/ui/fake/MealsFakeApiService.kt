package id.fatimazza.mymealapp.ui.fake

import id.fatimazza.mymealapp.data.model.MealsItem
import id.fatimazza.mymealapp.data.model.MealsResponse
import id.fatimazza.mymealapp.data.network.MealsApiService

class MealsFakeApiService : MealsApiService {
    override suspend fun getMeals(): MealsResponse {
        return MealsFakeDataSource.mealsList
    }
}
