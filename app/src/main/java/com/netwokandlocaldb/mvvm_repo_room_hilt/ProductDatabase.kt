package com.netwokandlocaldb.mvvm_repo_room_hilt

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDAO

    /*companion object {
        private var INSTANCE: ProductDatabase? = null
        fun getProduceRoomDatabase(context: Context): ProductDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }*/
}