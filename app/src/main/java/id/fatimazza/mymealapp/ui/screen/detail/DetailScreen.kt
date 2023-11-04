package id.fatimazza.mymealapp.ui.screen.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import id.fatimazza.mymealapp.R
import id.fatimazza.mymealapp.model.DetailItem
import id.fatimazza.mymealapp.ui.components.DetailTopBar
import id.fatimazza.mymealapp.ui.screen.ViewModelProvider
import id.fatimazza.mymealapp.ui.screen.home.ErrorScreen
import id.fatimazza.mymealapp.ui.screen.home.LoadingScreen
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme

@Composable
fun DetailScreen(
    menuId: String,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    viewModel: DetailViewModel = viewModel(factory = ViewModelProvider.Factory)
) {
    when (viewModel.detailUiState) {
        is DetailUiState.Loading -> {
            LoadingScreen(modifier.fillMaxSize())
            viewModel.getDetailData(menuId.toInt())
        }

        is DetailUiState.Success -> {
            DetailContent(
                detailMeals = (viewModel.detailUiState as DetailUiState.Success).meals,
                onBackPressed = onBackPressed
            )
        }

        is DetailUiState.Error -> {
            ErrorScreen(modifier.fillMaxSize())
        }
    }

}

@Composable
fun DetailContent(
    detailMeals: List<DetailItem>,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit
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
                DetailContentCard(
                    detailMeals = detailMeals,
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.detail_card_outer_padding_horizontal))
                )
            }
        }
    }
}

@Composable
private fun DetailContentCard(
    detailMeals: List<DetailItem>,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.detail_card_inner_padding))
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(detailMeals[0].strMealThumb)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.meals_photo),
                contentScale = ContentScale.Crop,
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_image),
                modifier = modifier
                    .fillMaxWidth()
                    .border(
                        BorderStroke(4.dp, MaterialTheme.colorScheme.primary),
                        RoundedCornerShape(15.dp)
                    )
                    .clip(RoundedCornerShape(15.dp))
            )
            Spacer(
                modifier = modifier.height(8.dp)
            )
            Text(
                text = stringResource(R.string.ingredients),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                text = detailMeals[0].strIngredient1.toString(),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify
            )
            Spacer(
                modifier = modifier.height(8.dp)
            )
            Text(
                text = stringResource(R.string.instruction),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                text = detailMeals[0].strInstructions.toString(),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    MyMealAppTheme {
        DetailScreen(
            menuId = "0",
            onBackPressed = {}
        )
    }
}
