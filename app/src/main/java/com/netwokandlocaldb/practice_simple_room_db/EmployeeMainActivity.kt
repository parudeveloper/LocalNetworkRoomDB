package com.netwokandlocaldb.practice_simple_room_db

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.netwokandlocaldb.R
import com.netwokandlocaldb.databinding.ActivityEmployeeMainBinding

class EmployeeMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityEmployeeMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeeMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun submitClicked(view: View) {
        val employeeDatabase = Room.databaseBuilder(
            applicationContext,
            EmployeeDatabase::class.java,
            "employee_database"
        ).allowMainThreadQueries().build()

        val employee = Employee(
            name = "Mallangi Reddy",
            profession = "Software Developer",
            expertise = "Android Developer"
        )
        employeeDatabase.employeeDAO().insertEmployeeData(employee)

        Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

    }

    fun getRecords(view: View) {
        val employeeDatabase = Room.databaseBuilder(
            applicationContext,
            EmployeeDatabase::class.java,
            "employee_database"
        ).allowMainThreadQueries().build()

        binding.tvRecordCount.text =
            "Total Recoards :${employeeDatabase.employeeDAO().getAllEmployeesData().size.toString()}"

    }
}