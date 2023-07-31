package com.rie.simpaduapp.ui.screen.home.ukt.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.ui.components.Category.Ukt.RiwayatPembayaran
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.home.ukt.viewmodel.UktViewModel
import com.rie.simpaduapp.base.Result
@Composable
fun HistoryUkt(
    modifier: Modifier = Modifier,
    viewModel: UktViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {
    val riwayatListState = viewModel.riwayatListState.collectAsState()
    val loadingState = viewModel.loadingState.collectAsState()
    val errorState = viewModel.errorState.collectAsState()

    if (loadingState.value) {

    } else if (errorState.value != null) {

    } else {

        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF))
                .padding(horizontal = 16.dp)
        ) {
            items(riwayatListState.value) { riwayat ->
                RiwayatPembayaran(
                    modifier = Modifier.padding(top = 5.dp),
                    status = riwayat.status,
                    tanggal_registrasi = riwayat.tanggal_registrasi,
                    tahun_akademik = riwayat.tahun_akademik
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getAllRiwayatP()
    }
}
