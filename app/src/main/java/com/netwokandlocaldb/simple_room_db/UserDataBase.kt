package com.netwokandlocaldb.simple_room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.netwokandlocaldb.simple_room_dbdata.User

@Database(entities = [User::class], version = 1)
abstract class UserDataBase : RoomDatabase(){
    //abstract fun userDao() = UserDAO
    abstract fun userDao(): UserDAO

}