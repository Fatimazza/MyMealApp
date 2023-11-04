package id.fatimazza.mymealapp.data

import id.fatimazza.mymealapp.data.model.DetailItem
import id.fatimazza.mymealapp.data.model.MealsItem
import id.fatimazza.mymealapp.data.network.MealsApiService

/**
 * Repository that fetch meals list from Meals Api.
 */
interface MealsRepository {
    suspend fun getMealsData(): List<MealsItem>
    suspend fun getDetailData(id: Int): List<DetailItem>
}

/**
 * Network Implementation of Repository that fetch Meals list from Meals Api.
 */
class NetworkMealsRepository(
    private val mealsApiService: MealsApiService
) : MealsRepository {
    override suspend fun getMealsData(): List<MealsItem> {
        return mealsApiService.getMeals().meals
    }

    override suspend fun getDetailData(id: Int): List<DetailItem> {
        return mealsApiService.getRecipeDetails(id).meals
    }
}
