package com.netwokandlocaldb.mvvm_corotine_hilt_flow_roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Hotel::class], version = 1)
abstract class HotelDatabase : RoomDatabase() {
    abstract fun getHotelDAO(): HotelDAO
}