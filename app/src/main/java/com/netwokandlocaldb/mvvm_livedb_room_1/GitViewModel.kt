package com.netwokandlocaldb.mvvm_livedb_room_1

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitViewModel(application: Application) : ViewModel() {
     var listOfGitData: LiveData<List<Git>>
    var repository: GitRepository

    init {
        var dataBase = GitDataBase.getRoomDatabase(application)
        val gitDAO = dataBase.getGitDao()
        repository = GitRepository(gitDAO)
        listOfGitData = repository.getAllData()

    }

    fun insertGitData(git: Git){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertGitData(git)
        }
    }
}