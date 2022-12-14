package com.example.naviassignment.ui.repository

import com.example.naviassignment.utils.NetworkResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseRepository {
    suspend inline fun <reified T> safeApiCall(
        dispatcher: CoroutineDispatcher,
        noinline apiCall: suspend () -> T
    ): NetworkResource<T> {
        return withContext(dispatcher) {
            try {
                NetworkResource.success(apiCall.invoke())
            } catch (throwable: Throwable) {
                processForError(throwable)
            }
        }
    }

    inline fun <reified T> processForError(
        throwable: Throwable
    ): NetworkResource<T> {
        return NetworkResource.error(throwable)
    }
}