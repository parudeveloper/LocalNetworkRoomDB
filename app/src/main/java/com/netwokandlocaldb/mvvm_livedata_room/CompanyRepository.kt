package com.netwokandlocaldb.mvvm_livedata_room

import androidx.lifecycle.LiveData

class CompanyRepository(private val companyDao: CompanyDao) {
    // var getCompanyData: LiveData<ArrayList<Company>>? = null

    suspend fun insertCompanyDetails(company: Company) {
        companyDao.insertCompanyData(company)
    }


     fun getAllCompanyDetails(): LiveData<List<Company>> = companyDao.getAllDetails()

  /*  suspend fun getAllCompanyDetails(): LiveData<ArrayList<Company>> {
        getCompanyData = companyDao.getAllDetails()
        return companyDao.getAllDetails()
    }*/
}