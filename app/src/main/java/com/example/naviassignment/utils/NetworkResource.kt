package com.example.naviassignment.utils

class NetworkResource<out T>(
    var status: Status,
    val data: T?,
    val throwable
    : Throwable?
) {
    val isSuccess: Boolean get() = status == Status.SUCCESS
    val isFailure: Boolean get() = status == Status.ERROR

    companion object {
        fun <T> success(data: T?): NetworkResource<T> {
            return NetworkResource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: Throwable? = null, data: T? = null): NetworkResource<T> {
            return NetworkResource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T? = null): NetworkResource<T> {
            return NetworkResource(Status.LOADING, data, null)
        }
    }

    inline fun <R, T> NetworkResource<T>.map(transform: (value: T) -> R): NetworkResource<R> {
        return when {
            isSuccess -> success(transform(data as T))
            else -> error(throwable)
        }
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }
}