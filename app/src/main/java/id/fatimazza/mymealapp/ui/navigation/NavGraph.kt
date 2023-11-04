package id.fatimazza.mymealapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.fatimazza.mymealapp.ui.FavoriteScreen
import id.fatimazza.mymealapp.ui.screen.detail.DetailScreen
import id.fatimazza.mymealapp.ui.screen.home.HomeScreen
import id.fatimazza.mymealapp.ui.screen.home.MealsUiState

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun MealNavHost(
    navController: NavHostController,
    mealsUiState: MealsUiState,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                mealsUiState = mealsUiState,
                navigateToDetail = { menuId ->
                    navController.navigate(Screen.DetailMenu.createRoute(menuId))
                }
            )
        }
        composable(route = Screen.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = Screen.DetailMenu.route) {
            DetailScreen()
        }
    }
}
