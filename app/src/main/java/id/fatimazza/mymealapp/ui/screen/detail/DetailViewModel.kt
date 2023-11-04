package id.fatimazza.mymealapp.ui.screen.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.fatimazza.mymealapp.data.MealsRepository
import id.fatimazza.mymealapp.data.model.DetailItem
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * UI state for the Home screen
 */
sealed interface DetailUiState {
    data class Success(val meals: List<DetailItem>) : DetailUiState
    object Error : DetailUiState
    object Loading : DetailUiState
}

class DetailViewModel(
    private val mealsRepository: MealsRepository
) : ViewModel() {

    /** The mutable State that stores the status of the most recent request */
    var detailUiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    /**
     * Gets Meals Detail information from the Meals API Retrofit service
     */
    fun getDetailData(id: Int) {
        viewModelScope.launch {
            try {
                val result = mealsRepository.getDetailData(id)
                detailUiState = DetailUiState.Success(
                    result
                )
            } catch (e: IOException) {
                detailUiState = DetailUiState.Error
            }
        }
    }
}
