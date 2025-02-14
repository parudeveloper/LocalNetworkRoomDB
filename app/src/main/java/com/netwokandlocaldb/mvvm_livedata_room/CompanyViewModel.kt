package com.netwokandlocaldb.mvvm_livedata_room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CompanyViewModel(application: Application) : AndroidViewModel(application) {

     var getAllData: LiveData<List<Company>>?=null
    var companyRepository: CompanyRepository


    init {
        val daoObject = CompanyDatabase.getCompanyDatabase(application).getCompanyDAO()
        companyRepository = CompanyRepository(daoObject)
        getAllData = companyRepository.getAllCompanyDetails()
    }

   /* private fun getAllCompaniesData(): LiveData<ArrayList<Company>>? {
        getAllData = companyRepository.getAllCompanyDetails()
        return getAllData

    }*/

    fun insertCompanyDetails(company: Company) {
        viewModelScope.launch {
            companyRepository.insertCompanyDetails(company)
        }
    }
}