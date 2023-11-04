package id.fatimazza.mymealapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import id.fatimazza.mymealapp.R
import id.fatimazza.mymealapp.data.model.DetailItem

@Composable
fun DetailTopBar(
    detailMeals: List<DetailItem>,
    onBackButtonClicked: () -> Unit,
    onFavPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = onBackButtonClicked,
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.detail_topbar_back_button_padding_horizontal))
                .background(MaterialTheme.colorScheme.surface, shape = CircleShape),
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.navigation_back)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = detailMeals[0].strMeal,
                maxLines = 2,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        IconButton(
            onClick = onFavPressed,
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.detail_topbar_back_button_padding_horizontal))
                .background(MaterialTheme.colorScheme.surface, shape = CircleShape),
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = stringResource(id = R.string.navigation_back)
            )
        }
    }
}
