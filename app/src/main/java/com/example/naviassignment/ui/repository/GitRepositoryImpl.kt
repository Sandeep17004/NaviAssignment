package com.example.naviassignment.ui.repository

import com.example.naviassignment.api.ApiServiceInterface
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.data.mapper.ApiGitRepositoryMapper
import com.example.naviassignment.utils.NetworkResource
import kotlinx.coroutines.CoroutineDispatcher

class GitRepositoryImpl(
    private val networkService: ApiServiceInterface,
    private val responseMapper: ApiGitRepositoryMapper,
    private var ioDispatcher: CoroutineDispatcher
) : BaseRepository(), GitRepository {
    override suspend fun loadClosedGitMergeRequestList(
        state: String,
        itemPerPage: Int,
        pageNumber: Int
    ): NetworkResource<List<GitResponse>> {
        return safeApiCall(ioDispatcher) {
            networkService.loadClosedGitMergeRequestList(state, itemPerPage, pageNumber)
                .map { responseMapper.toDomain(it) }
        }
    }
}

