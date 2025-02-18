package com.netwokandlocaldb.mvvm_corotine_hilt_flow_roomdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(private val hotelRepository: HotelRepository) :
    ViewModel() {
    private val _hotels = MutableStateFlow<List<Hotel>>(emptyList())
    val hotels: StateFlow<List<Hotel>> = _hotels.asStateFlow()
    /*private val _hotels = MutableSharedFlow<List<Hotel>>()
    val hotels: SharedFlow<List<Hotel>> = _hotels.asSharedFlow()*/

    init {
        //  hotels  = hotelRepository.getAllHotels()
        //hotels =hotelRepository.getAllHotels
        /*viewModelScope.launch(Dispatchers.IO) {
            hotelRepository.getAllHotels.collect { hotelData ->
                _hotels.emit(hotelData)
            }
        }*/

        viewModelScope.launch(Dispatchers.IO) {
            hotelRepository.getAllHotels.collect { hotelData ->
                _hotels.value = hotelData
            }
        }

    }

    fun insertHotels(hotel: Hotel) {
        viewModelScope.launch(Dispatchers.IO) {
            hotelRepository.insertHotels(hotel)

        }
    }
}