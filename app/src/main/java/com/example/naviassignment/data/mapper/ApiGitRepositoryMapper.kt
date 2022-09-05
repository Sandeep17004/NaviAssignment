package com.example.naviassignment.data.mapper

import com.example.naviassignment.data.ApiGitResponse
import com.example.naviassignment.data.GitResponse

class ApiGitRepositoryMapper : Mapper<ApiGitResponse, GitResponse> {
    override fun toDomain(model: ApiGitResponse): GitResponse {
        return try {
            GitResponse(
                title = model.title?.replaceFirstChar { it.uppercaseChar() },
                createdDate = model.createdAt,
                closedDate = model.closedAt,
                creatorName = model.user?.login?.replaceFirstChar { it.uppercaseChar() },
                creatorProfileImage = model.user?.avatarUrl,
                id = model.id
            )
        } catch (error: Exception) {
            throw Exception()
        }
    }
}