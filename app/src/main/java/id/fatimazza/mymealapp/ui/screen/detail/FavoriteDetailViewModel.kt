package id.fatimazza.mymealapp.ui.screen.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import id.fatimazza.mymealapp.data.FavMealsRepository
import id.fatimazza.mymealapp.data.local.FavoriteMealsItem

/**
 * ViewModel to validate and insert items in the Room database.
 */
class FavoriteDetailViewModel(private val favMealsRepository: FavMealsRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var favMealUiState by mutableStateOf(FavoriteMealUiState())
        private set

    /**
     * Update the item in the [FavMealsRepository]'s data source
     */
    suspend fun updateItem() {
        if (validateInput(favMealUiState.favMealDetails)) {
            favMealsRepository.updateItem(favMealUiState.favMealDetails.toItem())
        }
    }

    /**
     * Updates the [MealUiState] with the value provided in the argument.
     * This method also triggers a validation for input values.
     */
    fun updateUiState(favMealDetails: FavoriteMealDetails) {
        favMealUiState =
            FavoriteMealUiState(
                favMealDetails = favMealDetails,
                isEntryValid = validateInput(favMealDetails)
            )
    }

    suspend fun saveItem() {
        if (validateInput()) {
            favMealsRepository.insertItem(favMealUiState.favMealDetails.toItem())
        }
    }

    private fun validateInput(uiState: FavoriteMealDetails = favMealUiState.favMealDetails): Boolean {
        return with(uiState) {
            idMeal.isNotBlank() && strMeal.isNotBlank() && strMealThumb.isNotBlank()
        }
    }
}

/**
 * Represents Ui State for an Item.
 */
data class FavoriteMealUiState(
    val favMealDetails: FavoriteMealDetails = FavoriteMealDetails(),
    val isEntryValid: Boolean = false
)

data class FavoriteMealDetails(
    val favMealId: Int = 0,
    val idMeal: String = "",
    val strMeal: String = "",
    val strMealThumb: String = "",
)

/**
 * Extension function to convert [MealDetails] to [MealsItem].
 * All value can be manipulated here, for example invalid value set to 0
 */
fun FavoriteMealDetails.toItem(): FavoriteMealsItem = FavoriteMealsItem(
    favMealId = favMealId,
    idMeal = idMeal,
    strMeal = strMeal,
    strMealThumb = strMealThumb
)

/**
 * Extension function to convert [MealsItem] to [MealUiState]
 */
fun FavoriteMealsItem.toItemUiState(isEntryValid: Boolean = false): FavoriteMealUiState =
    FavoriteMealUiState(
        favMealDetails = this.toItemDetails(),
        isEntryValid = isEntryValid
    )

/**
 * Extension function to convert [MealsItem] to [MealItemDetails]
 */
fun FavoriteMealsItem.toItemDetails(): FavoriteMealDetails = FavoriteMealDetails(
    favMealId = favMealId,
    idMeal = idMeal,
    strMeal = strMeal,
    strMealThumb = strMealThumb
)
