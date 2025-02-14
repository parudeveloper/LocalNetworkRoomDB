package com.netwokandlocaldb.practice_simple_room_db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {

    abstract fun employeeDAO(): EmployeeDAO
}