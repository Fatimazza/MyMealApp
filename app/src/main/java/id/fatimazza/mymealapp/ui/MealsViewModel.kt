package id.fatimazza.mymealapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

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
    fun getMealsData() {
        mealsUiState = "Set the Mars API status response here!"
    }

}
