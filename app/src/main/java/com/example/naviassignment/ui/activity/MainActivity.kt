package com.example.naviassignment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.naviassignment.R
import com.example.naviassignment.databinding.ActivityMainBinding
import com.example.naviassignment.ui.adapter.GitRepoAdapter
import com.example.naviassignment.ui.viewModel.GitViewModel
import com.example.naviassignment.utils.NetworkResource
import com.example.naviassignment.utils.VerticalPaddingItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var screenBinding: ActivityMainBinding
    private val gitViewModel by viewModel<GitViewModel>()
    private val gitRepoAdapter by lazy { GitRepoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        screenBinding.apply {
            tvNoDataFound.setOnClickListener {
                screenBinding.noDataFound = false
                gitViewModel.loadClosedGitMergeRequestList()
            }
            rvGitData.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                addItemDecoration(
                    VerticalPaddingItemDecoration(
                        resources.getDimensionPixelOffset(
                            com.intuit.sdp.R.dimen._2sdp
                        )
                    )
                )
                adapter = gitRepoAdapter
            }
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        gitViewModel.getClosedGitMergeRequestLiveData().observe(this) { resObj ->
            when (resObj.status) {
                NetworkResource.Status.LOADING -> {
                    screenBinding.showLoading = true
                }
                NetworkResource.Status.SUCCESS -> {
                    screenBinding.showLoading = false
                    if (resObj.data?.isNotEmpty() == true) {
                        screenBinding.noDataFound = false
                        gitRepoAdapter.submitList(resObj.data)
                    } else {
                        screenBinding.noDataFound = true
                    }
                }
                NetworkResource.Status.ERROR -> {
                    screenBinding.apply {
                        showLoading = false
                        noDataFound = true
                    }
                    Toast.makeText(this, resObj.throwable.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}