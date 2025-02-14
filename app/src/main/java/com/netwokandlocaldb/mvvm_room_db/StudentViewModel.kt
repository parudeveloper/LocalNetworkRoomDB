package com.netwokandlocaldb.mvvm_room_db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class StudentViewModel(application: Application) : AndroidViewModel(application) {

    var studentList: List<Student>
    val repository: StudentRepository

    init {
        val dao = StudentDatabase.getDatabaseInstance(application).studentDAO()
        repository = StudentRepository(dao)
        studentList = repository.getAllData()
    }

    fun insertStudentData(student: Student) {
        repository.insertStudentData(student)
    }

}