package com.rie.simpaduapp.base.ui.common

sealed class UiState<out T: Any?> {

    object Loading : com.rie.simpaduapp.base.ui.common.UiState<Nothing>()

    data class Success<out T: Any>(val data: T) : com.rie.simpaduapp.base.ui.common.UiState<T>()

    data class Error(val errorMessage: String) : com.rie.simpaduapp.base.ui.common.UiState<Nothing>()
}