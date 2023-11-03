package id.fatimazza.mymealapp.model

import kotlinx.serialization.Serializable

@Serializable
data class MealResponse(
    val meals: List<MealsItem>
)

@Serializable
data class MealsItem(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
)
