package com.netwokandlocaldb.mvvm_livedb_room_1

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GitViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GitViewModel::class.java)) {
            return GitViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}