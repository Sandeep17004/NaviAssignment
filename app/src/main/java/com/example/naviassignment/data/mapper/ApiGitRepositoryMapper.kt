package com.example.naviassignment.data.mapper

import com.example.naviassignment.data.ApiGitResponse
import com.example.naviassignment.data.GitResponse

class ApiGitRepositoryMapper : Mapper<ApiGitResponse, GitResponse> {
    override fun toDomain(model: ApiGitResponse): GitResponse {
        return try {
            GitResponse(
                title = model.title,
                createdDate = model.createdAt,
                closedDate = model.closedAt,
                creatorName = model.user?.login,
                creatorProfileImage = model.user?.avatarUrl,
                id = model.id
            )
        } catch (error: Exception) {
            throw Exception()
        }
    }
}