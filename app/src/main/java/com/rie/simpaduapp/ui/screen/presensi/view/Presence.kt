package com.rie.simpaduapp.ui.screen.presensi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.components.Kehadiran
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.home.prestasi.viewmodel.PrestasiViewModel
import com.rie.simpaduapp.ui.screen.notification.viewmodel.NotificationViewModel
import com.rie.simpaduapp.ui.screen.presensi.viewmodel.PresenceViewModel
import com.rie.simpaduapp.base.Result

@Composable
fun Presence(
    modifier: Modifier = Modifier,
    viewModel: PresenceViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {
    val matkulResult = viewModel.nama_mk.collectAsState()

    when (val result = matkulResult.value) {
        is Result.Loading -> {
            // Tampilkan indikator loading jika diperlukan
        }
        is Result.Success -> {
            val presensiList = result.data
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFFFF))
                    .padding(horizontal = 16.dp)
            ) {
                items(presensiList) { presensi ->
                    Kehadiran(
                        id = presensi.id, // Pass the "id" from the data
                        nama_mk = presensi.nama_mk,
                        masih_dibuka = presensi.masih_dibuka
                    )
                }
            }
        }
        is Result.Error<*> -> {
            // Tangani keadaan error jika diperlukan
        }
    }

    // Ambil data saat komponen pertama kali ditampilkan
    LaunchedEffect(Unit) {
        viewModel.getAllPresence()
    }
}
