package id.fatimazza.mymealapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.fatimazza.mymealapp.R
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
            HomeResultScreen(
                mealsUiState.toString()
            )
        }
        is MealsUiState.Error -> {
            LoadingScreen(modifier.fillMaxSize())
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyMealAppTheme {
        HomeResultScreen(meals = "Home")
    }
}
