package com.netwokandlocaldb.mvvm_corotine_hilt_flow_roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.netwokandlocaldb.mvvm_livedata_room.Company
import kotlinx.coroutines.flow.Flow

@Dao
interface HotelDAO {

    @Insert
    suspend fun insertHotels(hotel: Hotel)

    @Query("SELECT * FROM hotel")
    fun getAllHotels():Flow<List<Hotel>>

}