package id.fatimazza.mymealapp.ui

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import id.fatimazza.mymealapp.R
import id.fatimazza.mymealapp.ui.navigation.MealNavHost
import id.fatimazza.mymealapp.ui.navigation.NavigationItem
import id.fatimazza.mymealapp.ui.navigation.Screen
import id.fatimazza.mymealapp.ui.screen.home.HomeViewModel
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyMealApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val mealsViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_title)) },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) {
        MealNavHost(
            mealsUiState = mealsViewModel.mealsUiState,
            navController = navController
        )
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        NavigationItem(
            title = stringResource(R.string.menu_home),
            icon = Icons.Default.Home,
            screen = Screen.Home
        ),
        NavigationItem(
            title = stringResource(R.string.menu_favorite),
            icon = Icons.Default.Favorite,
            screen = Screen.Favorite
        )
    )
    NavigationBar(
        modifier = modifier,
    ) {
        for (navItem in navigationItems) {
            NavigationBarItem(
                selected = currentRoute == navItem.screen.route,
                onClick = {
                    navController.navigate(navItem.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.title
                    )
                },
                label = { Text(navItem.title) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyMealAppPreview() {
    MyMealAppTheme {
        MyMealApp()
    }
}

