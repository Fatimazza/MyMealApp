package id.fatimazza.mymealapp.data

import id.fatimazza.mymealapp.model.MealsItem
import id.fatimazza.mymealapp.network.MealsApi
import id.fatimazza.mymealapp.network.MealsApiService

/**
 * Repository that fetch meals list from Meals Api.
 */
interface MealsRepository {
    suspend fun getMealsData(): List<MealsItem>
}

/**
 * Network Implementation of Repository that fetch Meals list from Meals Api.
 */
class NetworkMealsRepository() : MealsRepository {
    override suspend fun getMealsData(): List<MealsItem> {
        return MealsApi.retrofitService.getMeals().meals
    }
}
