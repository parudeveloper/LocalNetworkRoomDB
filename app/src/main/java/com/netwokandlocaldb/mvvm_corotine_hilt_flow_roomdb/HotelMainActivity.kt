package com.netwokandlocaldb.mvvm_corotine_hilt_flow_roomdb

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.netwokandlocaldb.R
import com.netwokandlocaldb.databinding.ActivityHotelMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
@AndroidEntryPoint
class HotelMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityHotelMainBinding
    lateinit var hotelViewModel: HotelViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHotelMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hotelViewModel = ViewModelProvider(this)[HotelViewModel::class.java]
        lifecycleScope.launch  {
            hotelViewModel.hotels.collect() {
                Log.i("HotelManagement",it.size.toString())
                binding.tvRecordCount.text = it.size.toString()
            }
        }
    }

    fun submitClicked(view: View) {
        val hotel = Hotel(name = "ABC Hotel", availability = true)
        hotelViewModel.insertHotels(hotel)
    }
}