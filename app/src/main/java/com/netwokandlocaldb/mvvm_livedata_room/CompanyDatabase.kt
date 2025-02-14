package com.netwokandlocaldb.mvvm_livedata_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Company::class], version = 1)
abstract class CompanyDatabase : RoomDatabase() {

    abstract fun getCompanyDAO(): CompanyDao

    companion object {
        private var INSTANCE: CompanyDatabase? = null

        fun getCompanyDatabase(context: Context): CompanyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CompanyDatabase::class.java,
                    "company_database"
                ).build()
                INSTANCE = instance
                instance

            }
        }
    }
}