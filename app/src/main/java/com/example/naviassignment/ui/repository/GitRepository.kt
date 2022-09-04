package com.example.naviassignment.ui.repository

import com.example.naviassignment.api.ApiService
import com.example.naviassignment.utils.NetworkResource

class GitRepository(
    private val network: ApiService
) {
    suspend fun fetchList(
        status: String
    ): NetworkResource<List<CabListDataModel>> {
        return try {
            network.loadClosedRepoList()
        } catch (error: Exception) {
            return NetworkResource.error(error)
        }
    }
}
}
