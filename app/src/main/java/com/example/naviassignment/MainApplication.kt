package com.example.naviassignment

import android.app.Application
import com.example.naviassignment.di.apiModule
import com.example.naviassignment.di.repositoryModule
import com.example.naviassignment.di.retrofitModule

import com.example.naviassignment.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(repositoryModule, viewModelModule, apiModule,retrofitModule))
        }
    }
}