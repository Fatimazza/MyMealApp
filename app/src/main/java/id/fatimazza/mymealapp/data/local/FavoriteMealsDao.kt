package id.fatimazza.mymealapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMealsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: FavoriteMealsItem)

    @Update
    suspend fun update(item: FavoriteMealsItem)

    @Delete
    suspend fun delete(item: FavoriteMealsItem)

    @Query("SELECT * from meals WHERE idMeal = :id")
    fun getItem(id: Int): Flow<FavoriteMealsItem>

    @Query("SELECT * from meals ORDER BY strMeal ASC")
    fun getAllItems(): Flow<List<FavoriteMealsItem>>
}

