package id.fatimazza.mymealapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MealViewModel() : ViewModel() {

    /** The mutable State that stores the status of the most recent request */
    var mealUiState: String by mutableStateOf("")
        private set

}
