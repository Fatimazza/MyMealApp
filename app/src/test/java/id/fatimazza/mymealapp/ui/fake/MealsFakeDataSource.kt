package id.fatimazza.mymealapp.ui.fake

import id.fatimazza.mymealapp.data.model.MealsItem
import id.fatimazza.mymealapp.data.model.MealsResponse

object MealsFakeDataSource {
    const val idOne = "51235"
    const val idTwo = "31234"
    const val strMealThumbOne = "url.1"
    const val strMealThumbTwo = "url.2"
    const val strMealOne = "Chicken Teriyaki"
    const val strMealTwo = "Takoyaki"

    val mealsList = MealsResponse(
        meals = listOf(
            MealsItem(
                idMeal = idOne,
                strMeal = strMealOne,
                strMealThumb = strMealThumbOne
            ),
            MealsItem(
                idMeal = idTwo,
                strMeal = strMealTwo,
                strMealThumb = strMealThumbTwo
            )
        )
    )
}
