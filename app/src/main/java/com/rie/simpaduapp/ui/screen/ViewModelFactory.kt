package com.rie.simpaduapp.ui.screen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rie.simpaduapp.data.Injection
import com.rie.simpaduapp.ui.screen.auth.viewmodel.LoginViewModel
import com.rie.simpaduapp.ui.screen.home.HomeViewModel
import com.rie.simpaduapp.ui.screen.home.jadwal.viewmodel.JadwalViewModel
import com.rie.simpaduapp.ui.screen.home.khs.viewmodel.KhsViewModel
import com.rie.simpaduapp.ui.screen.home.krs.viewmodel.KrsViewModel
import com.rie.simpaduapp.ui.screen.home.magang.viewmodel.InternViewModel
import com.rie.simpaduapp.ui.screen.home.prestasi.viewmodel.PrestasiViewModel
import com.rie.simpaduapp.ui.screen.home.skm.viewmodel.SkmViewModel
import com.rie.simpaduapp.ui.screen.home.ukt.viewmodel.UktViewModel
import com.rie.simpaduapp.ui.screen.home.wisuda.viewmodel.WisudaViewModel
import com.rie.simpaduapp.ui.screen.notification.viewmodel.NotificationViewModel
import com.rie.simpaduapp.ui.screen.presensi.viewmodel.PresenceViewModel
import com.rie.simpaduapp.ui.screen.profile.viewmodel.ProfileViewModel

class ViewModelFactory(private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(Injection.provideRepository(context)) as T
        }
       else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(Injection.provideRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(Injection.provideRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(PresenceViewModel::class.java)) {
            return PresenceViewModel(Injection.provideRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(NotificationViewModel::class.java)) {
            return NotificationViewModel(Injection.provideRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(JadwalViewModel::class.java)) {
            return JadwalViewModel(Injection.provideRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(KhsViewModel::class.java)) {
            return KhsViewModel(Injection.provideRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(KrsViewModel::class.java)) {
            return KrsViewModel(Injection.provideRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(InternViewModel::class.java)) {
            return InternViewModel(Injection.provideRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(PrestasiViewModel::class.java)) {
            return PrestasiViewModel(Injection.provideRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(SkmViewModel::class.java)) {
            return SkmViewModel(Injection.provideRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(UktViewModel::class.java)) {
            return UktViewModel(Injection.provideRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(WisudaViewModel::class.java)) {
            return WisudaViewModel(Injection.provideRepository(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}