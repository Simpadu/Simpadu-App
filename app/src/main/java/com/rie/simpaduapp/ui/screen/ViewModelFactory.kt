package com.rie.simpaduapp.ui.screen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rie.simpaduapp.data.Injection
import com.rie.simpaduapp.ui.screen.auth.viewmodel.LoginViewModel

class ViewModelFactory(private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(Injection.provideRepository(context)) as T
        }
//      else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
//            return HomeViewModel(Injection.provideRepository(context)) as T
//        } else if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
//            return ProfileViewModel(Injection.provideRepository(context)) as T
//        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}