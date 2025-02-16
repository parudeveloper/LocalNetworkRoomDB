package com.netwokandlocaldb.mvvm_repo_room_hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {
    var listOfProducts: LiveData<List<Product>>

    init {
        listOfProducts = productRepository.getListOfProducts()
    }

    fun insertProducts(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.insertProductData(product)
        }
    }
}