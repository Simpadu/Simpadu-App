package com.rie.simpaduapp.base.ui.screen.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rie.simpaduapp.repository.Repository

class LoginViewModel(private val repository: Repository): ViewModel() {
    private val _nimState = MutableLiveData("")
    val nimState: LiveData<String> get() =  _nimState
    private val _passwordState = MutableLiveData("")
    val passwordState: LiveData<String> get() =  _passwordState

    fun onNimChange(nim: String) {
        _nimState.value = nim
    }
    fun onPasswordChange(password: String) {
        _passwordState.value = password
    }

    fun login(nim: String, password: String) = repository.login(nim, password)

}