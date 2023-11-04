package id.fatimazza.mymealapp.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.fatimazza.mymealapp.data.FavMealsRepository
import id.fatimazza.mymealapp.data.local.FavoriteMealsItem
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/**
 * ViewModel to retrieve all items in the Room database.
 */
class FavoriteViewModel(favMealsRepository: FavMealsRepository) : ViewModel() {

    /**
     * Holds favorite ui state. The list of items are retrieved from [FavoriteMealsItem] and mapped to
     * [FavoriteUiState]
     */
    val favoriteUiState: StateFlow<FavoriteUiState> =
        favMealsRepository.getAllItemsStream().map { FavoriteUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = FavoriteUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * Ui State for FavoriteScreen
 */
data class FavoriteUiState(val itemList: List<FavoriteMealsItem> = listOf())


