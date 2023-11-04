package id.fatimazza.mymealapp.ui.screen.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.fatimazza.mymealapp.data.local.FavoriteMealsItem
import id.fatimazza.mymealapp.ui.components.MenuItem
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier
) {
    FavoriteGridScreen(meals = listOf(), navigateToDetail = {})
}

/**
 * The favorite screen displaying photo grid.
 */
@Composable
fun FavoriteGridScreen(
    meals: List<FavoriteMealsItem>,
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
            FavoriteMealPhotoCard(
                meal,
                navigateToDetail = navigateToDetail,
            )
        }
    }
}

@Composable
fun FavoriteMealPhotoCard(
    meals: FavoriteMealsItem,
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
fun FavoriteScreenPreview() {
    MyMealAppTheme {
        val mockData = List(10) { FavoriteMealsItem(it, "", "", "") }
        FavoriteGridScreen(meals = mockData, navigateToDetail = {} )
    }
}
