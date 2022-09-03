package com.example.naviassignment.ui.repository

import com.example.naviassignment.api.ApiService
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.utils.NetworkResource
import kotlinx.coroutines.Dispatchers

class GitRepository(
    private val networkService: ApiService
) : BaseRepository() {
    suspend fun fetchList(
        status: String
    ): NetworkResource<List<GitResponse>> {
        return safeApiCall(Dispatchers.IO) { (networkService.loadClosedRepoList(status)) }
    }
}

