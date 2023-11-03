package id.fatimazza.mymealapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.fatimazza.mymealapp.ui.MyMealApp
import id.fatimazza.mymealapp.ui.theme.MyMealAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMealAppTheme {
                MyMealApp()
            }
        }
    }
}
