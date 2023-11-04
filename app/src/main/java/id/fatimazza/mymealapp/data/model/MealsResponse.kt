package id.fatimazza.mymealapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MealsResponse(
    val meals: List<MealsItem>
)

@Serializable
data class MealsItem(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
)

