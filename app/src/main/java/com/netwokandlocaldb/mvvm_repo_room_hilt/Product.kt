package com.netwokandlocaldb.mvvm_repo_room_hilt

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val productName: String,
    val quantity: Int
) {
}