package id.fatimazza.mymealapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.fatimazza.mymealapp.network.MealsApi
import kotlinx.coroutines.launch
import java.io.IOException


/**
 * UI state for the Home screen
 */
sealed interface MealsUiState {
    data class Success(val meals: String) : MealsUiState
    object Error : MealsUiState
    object Loading : MealsUiState
}

class MealsViewModel() : ViewModel() {

    /** The mutable State that stores the status of the most recent request */
    var mealsUiState: MealsUiState by mutableStateOf(MealsUiState.Loading)
        private set

    init {
        getMealsData()
    }

    /**
     * Gets Meals information from the Meals API Retrofit service
     */
    private fun getMealsData() {
        viewModelScope.launch {
            try {
                val listResult = MealsApi.retrofitService.getMeals()
                mealsUiState = MealsUiState.Success(listResult)
            } catch (e: IOException) {
                mealsUiState = MealsUiState.Error
            }
        }
    }
}
