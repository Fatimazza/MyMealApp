package id.fatimazza.mymealapp.ui.fake

import id.fatimazza.mymealapp.data.model.DetailItem
import id.fatimazza.mymealapp.data.model.DetailResponse
import id.fatimazza.mymealapp.data.model.MealsItem
import id.fatimazza.mymealapp.data.model.MealsResponse

object MealsFakeDataSource {
    const val idOne = "51235"
    const val idTwo = "31234"
    const val strMealThumbOne = "url.1"
    const val strMealThumbTwo = "url.2"
    const val strMealOne = "Chicken Teriyaki"
    const val strMealTwo = "Takoyaki"
    const val strCategoryOne = "Seafood"
    const val strAreaOne = "Japan"

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

    val mealDetailList = DetailResponse(
        meals = listOf(
            DetailItem(
                idMeal = idOne,
                strMeal = strMealOne,
                strDrinkAlternate = null,
                strCategory = strCategoryOne,
                strArea = strAreaOne,
                strInstructions = null,
                strMealThumb = strMealThumbOne,
                strTags = null,
                strYoutube = null,
                strIngredient1 = null,
                strIngredient2 = null,
                strIngredient3 = null,
                strIngredient4 = null,
                strIngredient5 = null,
                strIngredient6 = null,
                strIngredient7 = null,
                strIngredient8 = null,
                strIngredient9 = null,
                strIngredient10 = null,
                strIngredient11 = null,
                strIngredient12 = null,
                strIngredient13 = null,
                strIngredient14 = null,
                strIngredient15 = null,
                strIngredient16 = null,
                strIngredient17 = null,
                strIngredient18 = null,
                strIngredient19 = null,
                strIngredient20 = null,
                strMeasure1 = null,
                strMeasure2 = null,
                strMeasure3 = null,
                strMeasure4 = null,
                strMeasure5 = null,
                strMeasure6 = null,
                strMeasure7 = null,
                strMeasure8 = null,
                strMeasure9 = null,
                strMeasure10 = null,
                strMeasure11 = null,
                strMeasure12 = null,
                strMeasure13 = null,
                strMeasure14 = null,
                strMeasure15 = null,
                strMeasure16 = null,
                strMeasure17 = null,
                strMeasure18 = null,
                strMeasure19 = null,
                strMeasure20 = null,
                strSource = null,
                strImageSource = null,
                strCreativeCommonsConfirmed = null,
                dateModified = null
            )
        )
    )
}
