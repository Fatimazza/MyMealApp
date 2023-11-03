package id.fatimazza.mymealapp.ui

import id.fatimazza.mymealapp.data.NetworkMealsRepository
import id.fatimazza.mymealapp.ui.fake.MealsFakeApiService
import id.fatimazza.mymealapp.ui.fake.MealsFakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMealsRepositoryTest {

    @Test
    fun networkMealsRepository_getMeals_verifyMealsList() =
        runTest {
            val repository = NetworkMealsRepository(
                mealsApiService = MealsFakeApiService()
            )
            assertEquals(MealsFakeDataSource.mealsList.meals, repository.getMealsData())
        }
}
