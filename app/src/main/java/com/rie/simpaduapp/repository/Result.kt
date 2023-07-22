package com.rie.simpaduapp.repository

sealed class Result<out R> private constructor() {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error<T>(val error: String) : Result<T>()

    object Loading : Result<Nothing>()
}