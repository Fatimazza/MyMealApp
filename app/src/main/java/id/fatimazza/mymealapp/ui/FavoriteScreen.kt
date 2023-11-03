package id.fatimazza.mymealapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import id.fatimazza.mymealapp.R
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.menu_favorite))
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteScreenPreview() {
    MyMealAppTheme {
        FavoriteScreen()
    }
}