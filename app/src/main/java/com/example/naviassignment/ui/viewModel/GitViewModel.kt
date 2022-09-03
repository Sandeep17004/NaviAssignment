package com.example.naviassignment.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.ui.repository.GitRepository
import com.example.naviassignment.utils.onFailure
import com.example.naviassignment.utils.onSuccess
import kotlinx.coroutines.launch

class GitViewModel(private val repository: GitRepository) : ViewModel() {
    val pullRequestList = MutableLiveData<MutableList<GitResponse>>()
    val isLoading = MutableLiveData(false)
    val showNoContent = MutableLiveData(false)
    private var page = 1

    init {
        loadRepoList()
    }

    fun loadRepoList() {
        if (isLoading.value == true) {
            return
        }
        isLoading.value = true

        viewModelScope.launch {
            repository.fetchList("closed")
                .onSuccess {
                    val currentNotifications =
                        pullRequestList.value?.let { ArrayList(it) } ?: ArrayList()

                    /*     if (reset) {
                             currentNotifications.clear()
                         }
     *//*
                    if (it.isNotEmpty()) {
                        page += 1
                    }
*/
                    val newNotifications = it.toMutableList()
                    newNotifications.removeAll(currentNotifications)

                    currentNotifications.addAll(newNotifications)

                    showNoContent.value = currentNotifications.isEmpty()
                    pullRequestList.value = currentNotifications

                    isLoading.value = false
                }.onFailure {
                    /* val errorMessage = (it as? ApiException)?.apiErrorMessage
                         ?: getString(R.string.audio_rooms_request_failed)

                     errorEvent.postValue(errorMessage)
                     isLoading.postValue(false)
                     showNoContent.postValue(notificationList.value.isNullOrEmpty())*/
                }
        }
    }
}