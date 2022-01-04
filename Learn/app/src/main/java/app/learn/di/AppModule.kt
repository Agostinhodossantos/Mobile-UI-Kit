package app.learn.di

import android.content.Context
import androidx.room.Room
import app.learn.data.local.ShoppingDao
import app.learn.data.local.ShoppingItemDatabase
import app.learn.data.remote.PixabayAPI
import app.learn.data.repositories.DefaultShoppingRepository
import app.learn.data.repositories.ShoppingRepository
import app.learn.other.Constants.BASE_URL
import app.learn.other.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providerShoppingItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ShoppingItemDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providesDefaultShoppingRepository(
        dao: ShoppingDao,
        api: PixabayAPI
    ) = DefaultShoppingRepository(dao, api) as ShoppingRepository

    @Singleton
    @Provides
    fun providerShoppingDao(
        database: ShoppingItemDatabase
    ) = database.shoppingDao()

    @Singleton
    @Provides
    fun providerPixabayApi(): PixabayAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayAPI::class.java)
    }
}