package com.example.naviassignment.api

import com.example.naviassignment.data.ApiGitResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(ApiConstants.Url.REPO_URL)
    suspend fun loadClosedRepoList(@Query("state") state: String): List<ApiGitResponse>
}