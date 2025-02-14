package com.netwokandlocaldb.mvvm_room_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudentDetails(student: Student)

    @Query("SELECT * FROM student")
    fun getAllStudentDetails(): List<Student>
}