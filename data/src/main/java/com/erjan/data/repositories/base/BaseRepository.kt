package com.erjan.data.repositories.base

import android.util.Log
import com.erjan.domain.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {

    protected fun <T> doRequest(
        doSomethingInSuccess: ((T) -> Unit)? = null,
        request: suspend () -> T
    ) = flow<Either<String, T>> {
        request().also { data ->
            doSomethingInSuccess?.invoke(data)
            emit(Either.Right(value = data))
        }
    }.flowOn(Dispatchers.IO).catch { exception ->
//        if (BuildConfig.DEBUG) {
            Log.e("RepositoryError", this@BaseRepository.javaClass.name, exception)
//        }
        emit(Either.Left(value = exception.localizedMessage ?: "Error Occurred!"))
    }
}