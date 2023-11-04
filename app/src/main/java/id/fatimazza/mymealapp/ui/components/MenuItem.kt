package id.fatimazza.mymealapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import id.fatimazza.mymealapp.R
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme

@Composable
fun MenuItem(
    id: String,
    image: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(image)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.meals_photo),
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_image),
            modifier = modifier
                .size(170.dp)
                .border(
                    BorderStroke(4.dp, MaterialTheme.colorScheme.inversePrimary),
                    RoundedCornerShape(15.dp)
                )
                .clip(RoundedCornerShape(15.dp))
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(
            modifier = modifier.height(16.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MenuItemPreview() {
    MyMealAppTheme {
        MenuItem("1", "imageUrl", "Ini judul makanan panjang")
    }
}
