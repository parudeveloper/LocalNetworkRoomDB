package com.netwokandlocaldb.mvvm_corotine_hilt_flow_roomdb

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HotelModule {

    @Provides
    @Singleton
    fun provideHotelDatabase(@ApplicationContext context: Context): HotelDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            HotelDatabase::class.java,
            "hotel_db"
        ).build()
    }

    @Provides
    fun provideHotelDAO(hotelDatabase: HotelDatabase): HotelDAO {
        return hotelDatabase.getHotelDAO()
    }

    @Provides
    fun providesHotelRepo(hotelDAO: HotelDAO) = HotelRepository(hotelDAO)
}