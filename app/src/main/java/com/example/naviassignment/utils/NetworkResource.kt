package com.example.naviassignment.utils

class NetworkResource<out T>(val value: Any?) {

    val isSuccess: Boolean get() = value !is Failure

    val isFailure: Boolean get() = value is Failure

    fun exceptionOrNull(): Throwable? = when (value) {
        is Failure -> value.exception
        else -> null
    }

    companion object {
        fun <T> success(value: T): NetworkResource<T> = NetworkResource(value)

        fun <T> failure(exception: Throwable): NetworkResource<T> =
            NetworkResource(createFailure(exception))
    }

    class Failure(val exception: Throwable) {
        override fun equals(other: Any?): Boolean = other is Failure && exception == other.exception
        override fun hashCode(): Int = exception.hashCode()
        override fun toString(): String = "Failure($exception)"
    }
}

private fun createFailure(exception: Throwable): Any = NetworkResource.Failure(exception)

inline fun <R, T> NetworkResource<T>.map(transform: (value: T) -> R): NetworkResource<R> {
    return when {
        isSuccess -> NetworkResource.success(transform(value as T))
        else -> NetworkResource(value)
    }
}

inline fun <T> NetworkResource<T>.onFailure(action: (exception: Throwable) -> Unit): NetworkResource<T> {
    exceptionOrNull()?.let { action(it) }
    return this
}

inline fun <T> NetworkResource<T>.onSuccess(action: (value: T) -> Unit): NetworkResource<T> {
    if (isSuccess) action(value as T)
    return this
}
