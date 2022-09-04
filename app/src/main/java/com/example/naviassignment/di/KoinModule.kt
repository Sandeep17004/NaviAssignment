package com.example.naviassignment.di

import com.example.naviassignment.R
import com.example.naviassignment.api.ApiService
import com.example.naviassignment.data.mapper.ApiGitRepositoryMapper
import com.example.naviassignment.ui.repository.GitRepository
import com.example.naviassignment.ui.repository.GitRepositoryImpl
import com.example.naviassignment.ui.viewModel.GitViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val viewModelModule = module { viewModel { GitViewModel(repository = get()) } }
val repositoryModule = module {
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

val apiModule = module {
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    single { provideApiService(get()) }
}
val retrofitModule = module {
    val connectTimeOut: Long = 40
    val readTimeOut: Long = 40
    val loggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
            .readTimeout(readTimeOut, TimeUnit.SECONDS)
            .addInterceptor { chain: Interceptor.Chain ->
                val newRequest = chain.request().newBuilder().build()
                chain.proceed(newRequest)
            }
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    single { provideHttpClient() }
    single {
        val baseurl = androidContext().getString(R.string.base_url)
        provideRetrofit(baseurl, get())
    }
}

