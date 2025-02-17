package com.netwokandlocaldb.mvvm_livedata_roomdb_1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.netwokandlocaldb.databinding.ActivityGitMainBinding

class GitMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityGitMainBinding
    lateinit var gitViewModel: GitViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGitMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModelFactory = GitViewModelFactory(application)
        gitViewModel=ViewModelProvider(this,viewModelFactory).get(GitViewModel::class.java)


             // gitViewModel = ViewModelProvider(this).get(GitViewModel::class.java)
        gitViewModel.listOfGitData.observe(this, Observer { gitData ->
            Log.i("GitMainActivity", gitData.size.toString())
            binding.tvRecordCount.text=gitData.size.toString()
        })

    }

    fun submitClicked(view: View) {
        val git = Git(userName = "ParuDeveloper", password = "IloveAndroid@143", reposCount = 19)
        gitViewModel.insertGitData(git)
    }
}