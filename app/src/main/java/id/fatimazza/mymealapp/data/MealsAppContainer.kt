package id.fatimazza.mymealapp.data

/**
 * Dependency Injection container at the application level.
 */
interface MealsAppContainer {
    val mealsRepository: MealsRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : MealsAppContainer {
    override val mealsRepository: MealsRepository
        get() = TODO("Not yet implemented")

}

