package id.fatimazza.mymealapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    mealsViewModel: MealsViewModel = viewModel()
) {
    HomeResultScreen(mealsViewModel.mealsUiState)
}

@Composable
fun HomeResultScreen(
    photos: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = photos)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyMealAppTheme {
        HomeScreen()
    }
}
