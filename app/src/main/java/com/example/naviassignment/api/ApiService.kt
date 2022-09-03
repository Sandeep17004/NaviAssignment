package com.example.naviassignment.api

import com.example.naviassignment.data.GitResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(ApiConstants.Url.REPO_URL)
    fun loadClosedRepoList(@Query("state") state: String): List<GitResponse>

}