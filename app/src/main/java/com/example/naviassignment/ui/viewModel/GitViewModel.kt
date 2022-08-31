package com.example.naviassignment.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.naviassignment.ui.repository.GitRepository

class GitViewModel(private val repository: GitRepository) : ViewModel() {
    val pullRequestList = MutableLiveData<MutableList<String>>()
    val isLoading = MutableLiveData(false)
    val showNoContent = MutableLiveData(false)

}