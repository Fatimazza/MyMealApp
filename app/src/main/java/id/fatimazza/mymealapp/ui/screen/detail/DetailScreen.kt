package id.fatimazza.mymealapp.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import id.fatimazza.mymealapp.R
import id.fatimazza.mymealapp.ui.components.DetailTopBar
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme

@Composable
fun DetailScreen(
) {
    DetailContent(
        onBackPressed = {}
    )
}

@Composable
fun DetailContent(
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                .padding(top = dimensionResource(R.dimen.detail_card_list_padding_top))
        ) {
            item {
                DetailTopBar(
                    onBackPressed,
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = dimensionResource(R.dimen.detail_topbar_padding_bottom))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    MyMealAppTheme {
        DetailScreen()
    }
}
