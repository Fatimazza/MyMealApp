package id.fatimazza.mymealapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.fatimazza.mymealapp.network.MealsApi
import kotlinx.coroutines.launch
import java.io.IOException

class MealsViewModel() : ViewModel() {

    /** The mutable State that stores the status of the most recent request */
    var mealsUiState: String by mutableStateOf("")
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
                mealsUiState = listResult
            } catch (e: IOException) {

            }
        }
    }
}
