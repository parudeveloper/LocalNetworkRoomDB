package com.netwokandlocaldb.practice_simple_room_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmployeeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployeeData(employee: Employee): Long

    @Query("SELECT * FROM employee")
    fun getAllEmployeesData(): List<Employee>
}