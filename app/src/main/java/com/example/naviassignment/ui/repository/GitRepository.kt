package com.example.naviassignment.ui.repository

import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.utils.NetworkResource

interface GitRepository {
    suspend fun loadClosedGitCommitsList(state: String): NetworkResource<List<GitResponse>>
}