package app.learn.data.repositories

import app.learn.data.local.ShoppingDao
import app.learn.data.remote.PixabayAPI
import javax.inject.Inject

class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayAPI: PixabayAPI
) {
}