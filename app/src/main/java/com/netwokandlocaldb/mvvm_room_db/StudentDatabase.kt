package com.netwokandlocaldb.mvvm_room_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.concurrent.Volatile

@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDAO(): StudentDAO

    companion object {
        /*  @Volatile
          private var INSTANCE: StudentDatabase? = null

          fun getDatabaseInstance(context: Context) : StudentDatabase{
              return INSTANCE ?: synchronized(context){
                  val instance = Room.databaseBuilder(context.applicationContext,StudentDatabase::class.java,"student_db").build()
                  INSTANCE=instance
                  instance
              }
          }*/

        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getDatabaseInstance(context: Context): StudentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java,
                    "student_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }

        }
    }
}