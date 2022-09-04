package com.example.naviassignment.di

import com.example.naviassignment.ui.viewModel.GitViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module { viewModel { GitViewModel(repository = get()) } }
