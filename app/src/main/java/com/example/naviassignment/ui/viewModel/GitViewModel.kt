package com.example.naviassignment.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.ui.repository.GitRepository
import com.example.naviassignment.utils.Constants.Companion.COMMIT_TYPE_CLOSED
import com.example.naviassignment.utils.NetworkResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GitViewModel(
    private val repository: GitRepository,
    private var ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val closedMergeRequestLiveData = MutableLiveData<NetworkResource<List<GitResponse>>>()

    fun getClosedGitMergeRequestLiveData(): MutableLiveData<NetworkResource<List<GitResponse>>> {
        return closedMergeRequestLiveData
    }

    init {
        loadClosedGitMergeRequestList()
    }

    fun loadClosedGitMergeRequestList() {
        closedMergeRequestLiveData.postValue(NetworkResource.loading())
        viewModelScope.launch {
            withContext(ioDispatcher) {
                val response = repository.loadClosedGitMergeRequestList(COMMIT_TYPE_CLOSED)
                closedMergeRequestLiveData.postValue(
                    NetworkResource.success(response.data)
                )
            }
        }
    }
}
