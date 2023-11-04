package id.fatimazza.mymealapp.ui.screen

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.fatimazza.mymealapp.MyMealsApplication
import id.fatimazza.mymealapp.ui.screen.favorite.FavoriteViewModel
import id.fatimazza.mymealapp.ui.screen.detail.DetailViewModel
import id.fatimazza.mymealapp.ui.screen.home.HomeViewModel


/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object ViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for HomeViewModel
        initializer {
            HomeViewModel(mealsApplication().container.mealsRepository)
        }
        // Initializer for DetailViewModel
        initializer {
            DetailViewModel(mealsApplication().container.mealsRepository)
        }
        // Initializer for FavoriteViewModel
        initializer {
            FavoriteViewModel(mealsApplication().container.favMealsRepository)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [MyMealsApplication].
 */
fun CreationExtras.mealsApplication(): MyMealsApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyMealsApplication)

