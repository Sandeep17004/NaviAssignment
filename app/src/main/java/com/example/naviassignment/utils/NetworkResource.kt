package com.example.naviassignment.utils

class NetworkResource<out T>(val value: Any?) {
    val isSuccess: Boolean get() = value !is Failure

    val isFailure: Boolean get() = value is Failure
    fun exceptionOrNull(): Throwable? = when (value) {
        is Failure -> value.exception
        else -> null
    }

    companion object {
        fun <T> success(value: T?): NetworkResource<T> {
            return NetworkResource(value)
        }

        fun <T> error(msg: Throwable): NetworkResource<T> {
            return NetworkResource(createFailure(msg))
        }
    }


    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    class Failure(val exception: Throwable) {
        override fun equals(other: Any?): Boolean = other is Failure && exception == other.exception
        override fun hashCode(): Int = exception.hashCode()
        override fun toString(): String = "Failure($exception)"
    }

}

private fun createFailure(exception: Throwable): Any = NetworkResource.Failure(exception)

inline fun <T> NetworkResource<T>.onFailure(action: (exception: Throwable) -> Unit): NetworkResource<T> {
    exceptionOrNull()?.let { action(it) }
    return this
}

inline fun <T> NetworkResource<T>.onSuccess(action: (value: T) -> Unit): NetworkResource<T> {
    if (isSuccess) action(value as T)
    return this
}