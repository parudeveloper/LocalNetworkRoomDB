package com.netwokandlocaldb.mvvm_repo_room_hilt

import androidx.lifecycle.LiveData
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productDAO: ProductDAO
) {

    suspend fun insertProductData(product: Product) {
        productDAO.insertProduct(product)
    }

    fun getListOfProducts(): LiveData<List<Product>> = productDAO.getAllProducts()

}