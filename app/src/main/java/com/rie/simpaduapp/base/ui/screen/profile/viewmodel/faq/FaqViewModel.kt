package com.rie.simpaduapp.base.ui.screen.profile.viewmodel.faq

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rie.simpaduapp.model.profile.FaqModel
import com.rie.simpaduapp.repository.FaqRepository
import com.rie.simpaduapp.base.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FaqViewModel (
    private val repository : FaqRepository
    ) : ViewModel() {
        private val _uiState : MutableStateFlow<com.rie.simpaduapp.base.ui.common.UiState<List<FaqModel>>> = MutableStateFlow(
            com.rie.simpaduapp.base.ui.common.UiState.Loading)
        val uiState : StateFlow<com.rie.simpaduapp.base.ui.common.UiState<List<FaqModel>>>
        get() = _uiState

        fun getAllFaqs(){
            viewModelScope.launch {
                repository.getAllFaqs()
                    .catch {
                        _uiState.value = com.rie.simpaduapp.base.ui.common.UiState.Error(it.message.toString())
                    }
                    .collect{FaqModel ->
                        _uiState.value = com.rie.simpaduapp.base.ui.common.UiState.Success(FaqModel)
                    }
            }
        }}
