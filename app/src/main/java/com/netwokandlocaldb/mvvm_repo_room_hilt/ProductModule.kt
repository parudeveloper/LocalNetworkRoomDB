package com.netwokandlocaldb.mvvm_repo_room_hilt

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductModule {

    @Provides
    @Singleton
    fun provideRoomDatabaseInstance(@ApplicationContext context: Context): ProductDatabase {
        return Room.databaseBuilder(context, ProductDatabase::class.java, "product_db").build()
    }

    @Provides
    fun provideDAO(productDatabase: ProductDatabase):ProductDAO {
        return productDatabase.getProductDao()

    }

    @Provides
    fun provideProductRepo(productDAO: ProductDAO) = ProductRepository(productDAO)
}