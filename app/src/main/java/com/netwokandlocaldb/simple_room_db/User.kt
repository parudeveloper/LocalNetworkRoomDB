package com.netwokandlocaldb.simple_room_dbdata

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val age: Int,
    val gender: String
)


