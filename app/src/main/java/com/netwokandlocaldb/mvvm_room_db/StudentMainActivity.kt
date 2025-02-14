package com.netwokandlocaldb.mvvm_room_db

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.netwokandlocaldb.R
import com.netwokandlocaldb.databinding.ActivityStudentMainBinding

class StudentMainActivity : AppCompatActivity() {
     val viewModel: StudentViewModel by viewModels()
    lateinit var binding: ActivityStudentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // viewModel = ViewModelProvider(this)[StudentViewModel::class.java].

      /*  viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(StudentViewModel::class.java)*/

    }

    fun submitClicked(view: View) {
        val student = Student(name = "Reddy", age = 24, marks = 98)
        viewModel.insertStudentData(student = student)

        Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_LONG).show()
    }

    fun getRecords(view: View) {
        binding.tvRecordCount.text = viewModel.studentList.size.toString()
        Toast.makeText(this, "Data Fetching Successfully", Toast.LENGTH_LONG).show()
    }
}