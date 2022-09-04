package com.example.naviassignment.di

import com.example.naviassignment.api.ApiServiceInterface
import com.example.naviassignment.data.mapper.ApiGitRepositoryMapper
import com.example.naviassignment.ui.repository.GitRepository
import com.example.naviassignment.ui.repository.GitRepositoryImpl
import org.koin.dsl.module

val RepositoryModule = module {
    fun provideGitRepository(
        api: ApiServiceInterface,
        gitRepositoryMapper: ApiGitRepositoryMapper
    ): GitRepository {
        return GitRepositoryImpl(api, gitRepositoryMapper)
    }
    single {
        provideGitRepository(get(), get())
    }
    factory { ApiGitRepositoryMapper() }
}