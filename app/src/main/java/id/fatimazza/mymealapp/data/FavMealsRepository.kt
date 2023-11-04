package id.fatimazza.mymealapp.data

import id.fatimazza.mymealapp.data.local.FavoriteMealsItem
import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */
interface FavMealsRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<List<FavoriteMealsItem>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<FavoriteMealsItem?>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: FavoriteMealsItem)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: FavoriteMealsItem)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(item: FavoriteMealsItem)
}
