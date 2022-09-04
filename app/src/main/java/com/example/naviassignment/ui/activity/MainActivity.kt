package com.example.naviassignment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.naviassignment.R
import com.example.naviassignment.ui.viewModel.GitViewModel
import com.example.naviassignment.utils.NetworkResource
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val gitViewModel by viewModel<GitViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeViewModel()
    }

    private fun observeViewModel() {
        gitViewModel.getClosedList().observe(this) { resObj ->
            when (resObj.status) {
                NetworkResource.Status.LOADING -> {

                }
                NetworkResource.Status.SUCCESS -> {
                    Toast.makeText(this, resObj?.data.toString(), Toast.LENGTH_SHORT).show()
                }
                NetworkResource.Status.ERROR -> {
                    Toast.makeText(this, resObj.throwable.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}