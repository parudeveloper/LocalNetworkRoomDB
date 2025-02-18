package com.netwokandlocaldb.mvvm_corotine_hilt_flow_roomdb

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HotelRepository @Inject constructor(private val hotelDAO: HotelDAO) {

    suspend fun insertHotels(hotel: Hotel) {
        hotelDAO.insertHotels(hotel)
    }

    /*var getAllHotels = flow {
        emit(hotelDAO.getAllHotels())
    }
*/
    val getAllHotels: Flow<List<Hotel>> = hotelDAO.getAllHotels()

}