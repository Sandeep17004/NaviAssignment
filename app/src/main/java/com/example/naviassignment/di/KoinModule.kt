package com.example.naviassignment.di

import com.example.naviassignment.api.ApiConstants
import com.example.naviassignment.api.ApiService
import com.example.naviassignment.ui.repository.GitRepository
import com.example.naviassignment.ui.viewModel.GitViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module { viewModel { GitViewModel(get()) } }

val repositoryModule = module {
    single {
        GitRepository(get())
    }
}
val apiModule = module {
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    single { provideApiService(get()) }

    val retrofitModule = module {

        fun provideGson(): Gson {
            return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
        }

        fun provideHttpClient(): OkHttpClient {
            val okHttpClientBuilder = OkHttpClient.Builder()
            /*.addInterceptor { chain ->
                val newRequest = chain.request().newBuilder().addHeader(
                    "Authorization", "token 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"
                ).addHeader("Accept", "application/vnd.github+json").build()
                chain.proceed(newRequest)
            }*/
            return okHttpClientBuilder.build()
        }

        fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(ApiConstants.Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(factory))
                .client(client)
                .build()
        }

        single { provideGson() }
        single { provideHttpClient() }
        single { provideRetrofit(get(), get()) }
    }
}