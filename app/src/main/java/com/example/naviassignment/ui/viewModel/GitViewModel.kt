package com.example.naviassignment.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naviassignment.data.ApiGitResponse
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.ui.repository.GitRepository
import com.example.naviassignment.utils.NetworkResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GitViewModel(private val repository: GitRepository) : ViewModel() {
    val pullRequestList = MutableLiveData<NetworkResource<List<GitResponse>>>()
    val isLoading = MutableLiveData(false)
    val showNoContent = MutableLiveData(false)
    private var page = 1

    fun getClosedList(): MutableLiveData<NetworkResource<List<GitResponse>>> {
        return pullRequestList
    }

    init {
        loadRepoList()
    }

    fun loadRepoList() {
        if (isLoading.value == true) {
            return
        }
        isLoading.value = true

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = repository.loadGitList("closed").data?.map {

                }

            }
            pullRequestList.postValue(repository.loadGitList("closed"))
        }
    }
}
