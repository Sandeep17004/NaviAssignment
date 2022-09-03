package com.example.naviassignment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.naviassignment.R
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.ui.viewModel.GitViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val gitViewModel by viewModel<GitViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gitViewModel.pullRequestList.observe(this, ::setList)
    }

    private fun setList(mutableList: MutableList<GitResponse>?) {

    }
}