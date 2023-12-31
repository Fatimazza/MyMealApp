package id.fatimazza.mymealapp.ui.screen.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.fatimazza.mymealapp.data.FavMealsRepository
import id.fatimazza.mymealapp.data.local.FavoriteMealsItem
import id.fatimazza.mymealapp.ui.navigation.Screen
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * ViewModel to validate and insert items in the Room database.
 */
class FavoriteDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val favMealsRepository: FavMealsRepository
) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var favMealUiState by mutableStateOf(FavoriteMealUiState())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[DetailDestination.detailIdArg])

    init {
        viewModelScope.launch {
            favMealUiState = favMealsRepository.getItemStream(itemId)
                .filterNotNull()
                .first()
                .toItemUiState(true)
        }
    }

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

    /**
     * Deletes the item from the [FavMealsRepository]'s data source.
     */
    suspend fun deleteItem() {
        favMealsRepository.deleteItem(favMealUiState.favMealDetails.toItem())
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
