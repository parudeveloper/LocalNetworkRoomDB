package com.netwokandlocaldb.mvvm_repo_room_hilt

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.netwokandlocaldb.R
import com.netwokandlocaldb.databinding.ActivityProductMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductMainActivity : AppCompatActivity() {
    lateinit var productViewModel: ProductViewModel
    lateinit var binding: ActivityProductMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        productViewModel.listOfProducts.observe(this, Observer { itemProduct ->
            binding.tvRecordCount.text = itemProduct.size.toString()

        })
    }

    fun submitClicked(view: View) {
        val product = Product(productName = "Bread", quantity = 32)
        productViewModel.insertProducts(product)
    }
}