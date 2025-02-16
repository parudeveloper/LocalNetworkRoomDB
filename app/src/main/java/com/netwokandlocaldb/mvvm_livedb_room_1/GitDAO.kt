package com.netwokandlocaldb.mvvm_livedb_room_1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GitDAO {

    @Insert
    suspend fun insertGitData(git: Git)


    @Query("SELECT * FROM git")
    fun getAllData() : LiveData<List<Git>>

}