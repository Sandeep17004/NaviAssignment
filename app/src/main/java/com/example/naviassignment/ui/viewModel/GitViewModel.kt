package com.example.naviassignment.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.ui.repository.GitRepository
import com.example.naviassignment.utils.Constants.Companion.COMMIT_TYPE_CLOSED
import com.example.naviassignment.utils.SingleLiveEvent
import com.example.naviassignment.utils.onFailure
import com.example.naviassignment.utils.onSuccess
import kotlinx.coroutines.launch
import java.lang.Exception

class GitViewModel(
    private val repository: GitRepository
) : ViewModel() {
    private val closedMergeRequestLiveData = MutableLiveData<MutableList<GitResponse>?>()
    private var page = 1
    val isLoading = MutableLiveData(false)
    val errorEvent = SingleLiveEvent<String>()
    val showNoContent = MutableLiveData(false)

    fun getClosedGitMergeRequestLiveData(): MutableLiveData<MutableList<GitResponse>?> {
        return closedMergeRequestLiveData
    }

    fun loadClosedGitMergeRequestList() {
        isLoading.value = true
        viewModelScope.launch {
            repository.loadClosedGitMergeRequestList(
                COMMIT_TYPE_CLOSED,
                itemPerPage = 20,
                pageNumber = page
            ).onSuccess { it ->
                val currentList =
                    closedMergeRequestLiveData.value?.let { ArrayList(it) } ?: ArrayList()
                if (it.isNotEmpty()) {
                    page += 1
                }
                val newList = it.toMutableList()
                currentList.addAll(newList)
                showNoContent.value = currentList.isEmpty()
                closedMergeRequestLiveData.value = currentList
                isLoading.value = false
            }.onFailure {
                val errorMessage = (it as? Exception)?.message ?: "Request Failed"
                errorEvent.postValue(errorMessage)
                isLoading.postValue(false)
                showNoContent.postValue(closedMergeRequestLiveData.value.isNullOrEmpty())
            }
        }
    }
}

