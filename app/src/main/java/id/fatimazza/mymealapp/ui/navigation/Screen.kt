package id.fatimazza.mymealapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("favorite")
    object DetailMenu : Screen("home/{menuId}") {
        fun createRoute(menuId: String) = "home/$menuId"
    }
}
