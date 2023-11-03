package id.fatimazza.mymealapp.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyMealApp() {
    HomeScreen()
}

@Preview(showBackground = true)
@Composable
fun MyMealAppPreview() {
    MyMealAppTheme {
        MyMealApp()
    }
}

