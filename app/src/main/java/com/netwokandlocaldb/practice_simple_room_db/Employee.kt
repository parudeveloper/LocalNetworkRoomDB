package com.netwokandlocaldb.practice_simple_room_db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val name :String,
    val profession :String,
    val expertise :String
)
