package com.rie.simpaduapp.ui.screen.presensi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.ui.components.Presence.RiwayatP
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.presensi.viewmodel.PresenceViewModel
import com.rie.simpaduapp.base.Result
import com.rie.simpaduapp.ui.screen.home.ukt.viewmodel.UktViewModel

@Composable
fun HistoryPresence(
    modifier: Modifier = Modifier,
    viewModel: PresenceViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {

    val matkulResult by viewModel.status.collectAsState()

    when (val result = matkulResult) {
        is Result.Loading -> {
            // TODO: Show loading UI
        }
        is Result.Success -> {
            val presensiList = result.data
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                    .padding(horizontal = 16.dp)
            ) {
                items(presensiList) { riwayat ->
                    RiwayatP(
                        pertemuan = riwayat.pertemuan.toString(),
                        nama_matkul = riwayat.nama_matkul,
                        status = riwayat.status,
                    )
                }
            }
        }
        is Result.Error<*> -> {
            // TODO: Show error UI
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getRiwayatPresence()
    }
}
