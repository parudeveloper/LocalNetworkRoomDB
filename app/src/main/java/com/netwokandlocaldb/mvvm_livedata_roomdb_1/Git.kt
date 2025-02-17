package com.netwokandlocaldb.mvvm_livedata_roomdb_1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Git(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val userName: String,
    val password: String,
    val reposCount: Int
)
