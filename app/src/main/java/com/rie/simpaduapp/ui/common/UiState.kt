package com.rie.simpaduapp.ui.common

sealed class UiState<out T: Any?> {

    object Loading : com.rie.simpaduapp.ui.common.UiState<Nothing>()

    data class Success<out T: Any>(val data: T) : com.rie.simpaduapp.ui.common.UiState<T>()

    data class Error(val errorMessage: String) : com.rie.simpaduapp.ui.common.UiState<Nothing>()
}