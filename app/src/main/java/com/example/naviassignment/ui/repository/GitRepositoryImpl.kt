package com.example.naviassignment.ui.repository

import com.example.naviassignment.api.ApiServiceInterface
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.data.mapper.ApiGitRepositoryMapper
import com.example.naviassignment.utils.NetworkResource
import kotlinx.coroutines.Dispatchers

class GitRepositoryImpl(
    private val networkService: ApiServiceInterface,
    private val responseMapper: ApiGitRepositoryMapper
) : BaseRepository(), GitRepository {
    override suspend fun loadClosedGitMergeRequestList(state: String): NetworkResource<List<GitResponse>> {
        return safeApiCall(Dispatchers.IO) {
            networkService.loadClosedGitMergeRequestList(state).map { responseMapper.toDomain(it) }
        }
    }
}

