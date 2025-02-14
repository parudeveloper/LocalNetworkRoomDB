package com.netwokandlocaldb.mvvm_livedata_room

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.netwokandlocaldb.R
import com.netwokandlocaldb.databinding.ActivityCompanyMainBinding

class CompanyMainActivity : AppCompatActivity() {
    lateinit var companyViewModel: CompanyViewModel
    lateinit var binding: ActivityCompanyMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompanyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        companyViewModel = ViewModelProvider(this).get(CompanyViewModel::class.java)

       /* companyViewModel.getAllData?.observe(this) {
            binding.tvRecordCount.text = it.size.toString()
        }*/

        companyViewModel.getAllData?.observe(this, Observer { companyData ->
            // Update the UI with the list of users
            // For example, you can set it to a RecyclerView

            binding.tvRecordCount.text = companyData.size.toString()
        })

    }

    fun submitClicked(view: View) {
        val company = Company(
            name = "Mallangi",
            address = "Kadapa",
            employeeCount = 200,
            ceo = "Parameswar Reddy"
        )
        companyViewModel.insertCompanyDetails(company)
        Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_LONG).show()

    }
}