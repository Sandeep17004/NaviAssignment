package com.example.naviassignment.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.ui.repository.GitRepository
import com.example.naviassignment.utils.Constants.Companion.COMMIT_TYPE_CLOSED
import com.example.naviassignment.utils.NetworkResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GitViewModel(private val repository: GitRepository) : ViewModel() {
    private val pullRequestList = MutableLiveData<NetworkResource<List<GitResponse>>>()

    fun getClosedList(): MutableLiveData<NetworkResource<List<GitResponse>>> {
        return pullRequestList
    }

    init {
        loadClosedGitCommitsList()
    }

    fun loadClosedGitCommitsList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                pullRequestList.postValue(repository.loadClosedGitCommitsList(COMMIT_TYPE_CLOSED))
            }
        }
    }
}
