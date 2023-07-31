package com.rie.simpaduapp.ui.screen.notification.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import com.rie.simpaduapp.base.PengumumanResponse
import com.rie.simpaduapp.ui.components.Category.Magang.Magang
import com.rie.simpaduapp.ui.components.Notifikasi.PengumumanC
import com.rie.simpaduapp.ui.screen.notification.viewmodel.NotificationViewModel
import com.rie.simpaduapp.base.Result
import com.rie.simpaduapp.ui.screen.ViewModelFactory

@Composable
fun Announcement(
    modifier: Modifier = Modifier,
    viewModel: NotificationViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {
    val judulResult = viewModel.judul.collectAsState()

    when (val judul = judulResult.value) {
        is Result.Loading -> {
        }
        is Result.Success -> {
            val pengumumanList = judul.data
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFFFF))
                    .padding(horizontal = 16.dp)
            ) {
                items(pengumumanList) { pengumuman ->
                    PengumumanC(judul = pengumuman.judul, url = pengumuman.url)
                }
            }
        }
        is Result.Error<*> -> {
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getAllPengumuman()
    }
}

