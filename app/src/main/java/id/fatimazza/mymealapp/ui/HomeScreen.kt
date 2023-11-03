package id.fatimazza.mymealapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme

@Composable
fun HomeScreen(
    mealsUiState: MealsUiState
) {
    when (mealsUiState) {
        is MealsUiState.Success ->
            HomeResultScreen(
                mealsUiState.meals
            )

        else -> {
            HomeResultScreen(
                mealsUiState.toString()
            )
        }
    }
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
