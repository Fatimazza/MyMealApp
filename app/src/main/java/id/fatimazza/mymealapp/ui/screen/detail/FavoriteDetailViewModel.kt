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
    var favDetailUiState by mutableStateOf(InventoryItemUiState())
        private set

    /**
     * Update the item in the [ItemsRepository]'s data source
     */
    suspend fun updateItem() {
        if (validateInput(favDetailUiState.itemDetails)) {
            favMealsRepository.updateItem(favDetailUiState.itemDetails.toItem())
        }
    }

    /**
     * Updates the [favDetailUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: FavoriteItemDetails) {
        favDetailUiState =
            InventoryItemUiState(
                itemDetails = itemDetails,
                isEntryValid = validateInput(itemDetails)
            )
    }

    suspend fun saveItem() {
        if (validateInput()) {
            favMealsRepository.insertItem(favDetailUiState.itemDetails.toItem())
        }
    }

    private fun validateInput(uiState: FavoriteItemDetails = favDetailUiState.itemDetails): Boolean {
        return with(uiState) {
            idMeal.isNotBlank() && strMeal.isNotBlank() && strMealThumb.isNotBlank()
        }
    }
}

/**
 * Represents Ui State for an Item.
 */
data class InventoryItemUiState(
    val itemDetails: FavoriteItemDetails = FavoriteItemDetails(),
    val isEntryValid: Boolean = false
)

data class FavoriteItemDetails(
    val favMealId: Int = 0,
    val idMeal: String = "",
    val strMeal: String = "",
    val strMealThumb: String = "",
)

/**
 * Extension function to convert [ItemDetails] to [Item]. If the value of [ItemDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [ItemDetails.quantity] is not a valid [Int], then the quantity will be set to 0
 */
fun FavoriteItemDetails.toItem(): FavoriteMealsItem = FavoriteMealsItem(
    favMealId = favMealId,
    idMeal = idMeal,
    strMeal = strMeal,
    strMealThumb = strMealThumb
)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun FavoriteMealsItem.toItemUiState(isEntryValid: Boolean = false): InventoryItemUiState =
    InventoryItemUiState(
        itemDetails = this.toItemDetails(),
        isEntryValid = isEntryValid
    )

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun FavoriteMealsItem.toItemDetails(): FavoriteItemDetails = FavoriteItemDetails(
    favMealId = favMealId,
    idMeal = idMeal,
    strMeal = strMeal,
    strMealThumb = strMealThumb
)
