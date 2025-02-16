package com.netwokandlocaldb.mvvm_repo_room_hilt

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDAO {

    @Insert
    suspend fun insertProduct(product: Product)


    @Query("SELECT * FROM product")
    fun getAllProducts(): LiveData<List<Product>>


}