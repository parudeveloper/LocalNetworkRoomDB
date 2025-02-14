package com.netwokandlocaldb.mvvm_livedata_room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Company(
    @PrimaryKey(autoGenerate = true)
    val companyId: Int=0,
    val name: String,
    val address: String,
    val employeeCount: Int,
    val ceo: String

)
