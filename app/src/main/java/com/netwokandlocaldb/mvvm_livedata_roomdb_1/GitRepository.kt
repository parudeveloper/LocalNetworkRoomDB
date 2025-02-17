package com.netwokandlocaldb.mvvm_livedata_roomdb_1

import androidx.lifecycle.LiveData

class GitRepository(private val gitDAO: GitDAO) {

    suspend fun insertGitData(git: Git){
        gitDAO.insertGitData(git)
    }

     fun getAllData() :LiveData<List<Git>> = gitDAO.getAllData()
}