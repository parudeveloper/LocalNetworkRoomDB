package com.netwokandlocaldb.mvvm_corotine_hilt_flow_roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hotel(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name : String,
    val availability:Boolean,
) {
}