package com.netwokandlocaldb.simple_room_db

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.netwokandlocaldb.R
import com.netwokandlocaldb.databinding.ActivityUserMainBinding
import com.netwokandlocaldb.simple_room_dbdata.User

class UserMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun submitClicked(view: View) {
        val roomDatabase: UserDataBase =
            Room.databaseBuilder(applicationContext, UserDataBase::class.java, "user_database").allowMainThreadQueries()
                .build()

        var user = User(name = "Mallangi", age = 28, gender = "Male")
        roomDatabase.userDao().insertUser(user)
        Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()
    }

    fun getRecords(view: View) {
        val userRoomDatabase =
            Room.databaseBuilder(applicationContext, UserDataBase::class.java, "user_database").allowMainThreadQueries()
                .build()

        binding.tvRecordCount.text= "Total Recoards :${userRoomDatabase.userDao().getAllUser().size}"

    }
}