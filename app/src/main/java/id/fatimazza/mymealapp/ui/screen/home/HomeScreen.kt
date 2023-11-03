package id.fatimazza.mymealapp.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.fatimazza.mymealapp.R
import id.fatimazza.mymealapp.model.MealsItem
import id.fatimazza.mymealapp.ui.components.MenuItem
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme

@Composable
fun HomeScreen(
    mealsUiState: MealsUiState,
    modifier: Modifier = Modifier
) {
    when (mealsUiState) {
        is MealsUiState.Loading ->
            LoadingScreen(modifier.fillMaxSize())

        is MealsUiState.Success -> {
            PhotosGridScreen(
                meals = mealsUiState.meals,
                modifier = modifier
            )
        }

        is MealsUiState.Error -> {
            ErrorScreen(modifier.fillMaxSize())
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_image),
        contentDescription = stringResource(R.string.loading)
    )
}

/**
 * The home screen displaying photo grid.
 */
@Composable
fun PhotosGridScreen(
    meals: List<MealsItem>,
    modifier: Modifier = Modifier
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
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(1.0f)
            )
        }
    }
}

@Composable
fun MealPhotoCard(
    meals: MealsItem, modifier: Modifier = Modifier
) {
    MenuItem(
        id = meals.idMeal,
        image = meals.strMealThumb,
        title = meals.strMeal
    )
}

@Composable
fun HomeResultScreen(
    meals: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = meals)
    }
}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_connection_error
            ), contentDescription = ""
        )
        Text(
            text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    MyMealAppTheme {
        ErrorScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HomePhotoGridPreview() {
    MyMealAppTheme {
        val mockData = List(10) { MealsItem("$it", "", "") }
        PhotosGridScreen(mockData)
    }
}
