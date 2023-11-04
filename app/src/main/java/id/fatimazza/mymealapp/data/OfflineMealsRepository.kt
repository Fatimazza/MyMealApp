package id.fatimazza.mymealapp.data

import id.fatimazza.mymealapp.data.local.FavoriteMealsDao
import id.fatimazza.mymealapp.data.local.FavoriteMealsItem
import kotlinx.coroutines.flow.Flow

class OfflineMealsRepository(private val itemDao: FavoriteMealsDao) : FavMealsRepository {
    override fun getAllItemsStream(): Flow<List<FavoriteMealsItem>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<FavoriteMealsItem?> = itemDao.getItem(id)

    override suspend fun insertItem(item: FavoriteMealsItem) = itemDao.insert(item)

    override suspend fun deleteItem(item: FavoriteMealsItem) = itemDao.delete(item)

    override suspend fun updateItem(item: FavoriteMealsItem) = itemDao.update(item)
}
