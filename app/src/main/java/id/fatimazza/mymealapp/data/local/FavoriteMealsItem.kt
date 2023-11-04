package id.fatimazza.mymealapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity data class represents a single row in the database.
 */
@Entity(tableName = "meals")
class FavoriteMealsItem(
    @PrimaryKey(autoGenerate = true)
    val favMealId: Int = 0,
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val quantity: Int
)

