package com.netwokandlocaldb.simple_room_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.netwokandlocaldb.simple_room_dbdata.User

@Dao
interface UserDAO {

   /* @Insert
    fun insertUserData(user: User) :User

    @Query("select * from user")
    fun getAllUserDetails() :List<User>*/




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User) : Long

    @Query("SELECT * FROM user")
    fun getAllUser() : List<User>
}