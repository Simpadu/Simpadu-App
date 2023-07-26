package com.rie.simpaduapp.ui.screen.profile.viewmodel

import androidx.lifecycle.ViewModel
import com.rie.simpaduapp.base.DefaultResponse
import com.rie.simpaduapp.repository.Repository
import com.rie.simpaduapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel(private val repository: Repository) :  ViewModel()  {
    private val _logout: MutableStateFlow<UiState<DefaultResponse>> = MutableStateFlow(
        UiState.Loading
    )
    val logout: StateFlow<UiState<DefaultResponse>>
        get() = _logout

    fun logout() = repository.logout()
}