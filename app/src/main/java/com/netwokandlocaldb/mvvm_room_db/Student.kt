package com.netwokandlocaldb.mvvm_room_db

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val age: Int,
    val marks: Int
)
