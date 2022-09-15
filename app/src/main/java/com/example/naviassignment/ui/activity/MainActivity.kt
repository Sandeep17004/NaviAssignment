package com.example.naviassignment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.naviassignment.R
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.databinding.ActivityMainBinding
import com.example.naviassignment.ui.adapter.GitRepoAdapter
import com.example.naviassignment.ui.viewModel.GitViewModel
import com.example.naviassignment.utils.Util
import com.example.naviassignment.utils.VerticalPaddingItemDecoration
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var screenBinding: ActivityMainBinding
    private val gitViewModel by viewModel<GitViewModel>()
    private val gitRepoAdapter by lazy { GitRepoAdapter() }
    private var isPaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        screenBinding.apply {
            tvNoDataFound.setOnClickListener {
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
        observeStateChange()
        gitViewModel.apply {
            errorEvent.observe(this@MainActivity, ::displayError)
            getClosedGitMergeRequestLiveData().observe(this@MainActivity, ::setDataToAdapter)
        }
        if (Util.isOnline(this)) {
            gitViewModel.loadClosedGitMergeRequestList()
        } else {
            Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setDataToAdapter(notifications: List<GitResponse>?) {
        gitRepoAdapter.submitList(notifications ?: emptyList())
    }

    private fun displayError(message: String) {
        Snackbar.make(screenBinding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun observeStateChange() {
        screenBinding.rvGitData.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    gitViewModel.loadClosedGitMergeRequestList()
                }
            }

        })
    }

    override fun onPause() {
        super.onPause()
        isPaused = true
    }
}