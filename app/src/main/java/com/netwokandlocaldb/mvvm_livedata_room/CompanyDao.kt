package com.netwokandlocaldb.mvvm_livedata_room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CompanyDao {
    @Insert
    suspend fun insertCompanyData(company: Company)

    @Query("SELECT * FROM company")
    fun getAllDetails(): LiveData<List<Company>>

}