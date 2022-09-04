package com.example.naviassignment.di

import com.example.naviassignment.api.ApiService
import com.example.naviassignment.data.mapper.ApiGitRepositoryMapper
import com.example.naviassignment.ui.repository.GitRepository
import com.example.naviassignment.ui.repository.GitRepositoryImpl
import org.koin.dsl.module

val RepositoryModule = module {
    fun provideGitRepository(
        api: ApiService,
        gitRepositoryMapper: ApiGitRepositoryMapper
    ): GitRepository {
        return GitRepositoryImpl(api, gitRepositoryMapper)
    }
    single {
        provideGitRepository(get(), get())
    }
    factory { ApiGitRepositoryMapper() }
}