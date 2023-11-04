package id.fatimazza.mymealapp.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.fatimazza.mymealapp.data.model.MealsItem
import id.fatimazza.mymealapp.ui.components.ErrorScreen
import id.fatimazza.mymealapp.ui.components.LoadingScreen
import id.fatimazza.mymealapp.ui.components.MenuItem
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme

@Composable
fun HomeScreen(
    mealsUiState: MealsUiState,
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit,
) {
    when (mealsUiState) {
        is MealsUiState.Loading ->
            LoadingScreen(modifier.fillMaxSize())

        is MealsUiState.Success -> {
            PhotosGridScreen(
                meals = mealsUiState.meals,
                modifier = modifier,
                navigateToDetail = navigateToDetail,
            )
        }

        is MealsUiState.Error -> {
            ErrorScreen(modifier.fillMaxSize())
        }
    }
}

/**
 * The home screen displaying photo grid.
 */
@Composable
fun PhotosGridScreen(
    meals: List<MealsItem>,
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(
            items = meals, key = { meal -> meal.idMeal }
        ) { meal ->
            MealPhotoCard(
                meal,
                navigateToDetail = navigateToDetail,
            )
        }
    }
}

@Composable
fun MealPhotoCard(
    meals: MealsItem,
    navigateToDetail: (String) -> Unit,
) {
    MenuItem(
        id = meals.idMeal,
        image = meals.strMealThumb,
        title = meals.strMeal,
        modifier = Modifier.clickable {
            navigateToDetail(meals.idMeal)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomePhotoGridPreview() {
    MyMealAppTheme {
        val mockData = List(10) { MealsItem("$it", "", "") }
        PhotosGridScreen(
            meals = mockData,
            navigateToDetail = {}
        )
    }
}
