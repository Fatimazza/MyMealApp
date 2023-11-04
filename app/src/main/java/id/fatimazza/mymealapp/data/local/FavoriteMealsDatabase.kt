package id.fatimazza.mymealapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [FavoriteMealsItem::class], version = 1, exportSchema = false)
abstract class FavoriteMealsDatabase : RoomDatabase() {

    abstract fun itemDao(): FavoriteMealsDao

    companion object {
        @Volatile
        private var Instance: FavoriteMealsDatabase? = null

        fun getDatabase(context: Context): FavoriteMealsDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, FavoriteMealsDatabase::class.java, "fav_meals_database")
                    .build().also { Instance = it }
            }
        }
    }
}

