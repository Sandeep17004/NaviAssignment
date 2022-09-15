package com.example.naviassignment.api

import com.example.naviassignment.data.ApiGitResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceInterface {
    @GET(ApiConstants.Url.REPO_URL)
    suspend fun loadClosedGitMergeRequestList(
        @Query("state") state: String,
        @Query("per_page") itemPerPage: Int,
        @Query("page") pageNumber: Int
    ): List<ApiGitResponse>
}