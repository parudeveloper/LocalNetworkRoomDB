package com.netwokandlocaldb.mvvm_livedata_roomdb_1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Git::class], version = 1)
abstract class GitDataBase : RoomDatabase() {

    abstract fun getGitDao(): GitDAO


    companion object {
        private var INSTANCE: GitDataBase? = null
         fun getRoomDatabase(context: Context): GitDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GitDataBase::class.java,
                    "git_database"
                ).build()
                INSTANCE = instance
                instance
            }

        }
    }


}