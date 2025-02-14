package com.netwokandlocaldb.mvvm_room_db

class StudentRepository(private val dao: StudentDAO) {

    fun insertStudentData(student: Student){
        dao.insertStudentDetails(student)
    }

    fun getAllData() : List<Student>{
        return dao.getAllStudentDetails()
    }

}