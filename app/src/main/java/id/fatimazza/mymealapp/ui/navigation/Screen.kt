package id.fatimazza.mymealapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("favorite")
    object DetailMenu : Screen("home/{menuId}") {

        var menuDetailId = ""
        fun createMenuDetailId (menuId: String) {
            menuDetailId = menuId
        }

        fun createRoute(menuId: String) = "home/$menuId"
    }
}
