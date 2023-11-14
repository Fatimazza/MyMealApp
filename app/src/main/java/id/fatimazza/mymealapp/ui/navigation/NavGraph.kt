package id.fatimazza.mymealapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import id.fatimazza.mymealapp.ui.screen.detail.DetailDestination
import id.fatimazza.mymealapp.ui.screen.favorite.FavoriteScreen
import id.fatimazza.mymealapp.ui.screen.detail.DetailScreen
import id.fatimazza.mymealapp.ui.screen.favorite.FavoriteDestination
import id.fatimazza.mymealapp.ui.screen.home.HomeDestination
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
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                mealsUiState = mealsUiState,
                navigateToDetail = {
                    navController.navigate("${DetailDestination.route}/${it}")
                }
            )
        }
        composable(route = FavoriteDestination.route) {
            FavoriteScreen()
        }
        composable(
            route = DetailDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailDestination.detailIdArg) {
                type = NavType.IntType
            }),
        ) {
            val id = it.arguments?.getInt(DetailDestination.detailIdArg) ?: 0
            DetailScreen(
                menuId = id,
                onBackPressed = { navController.navigateUp() }
            )
        }
    }
}
