package com.rie.simpaduapp.ui.screen.presensi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.ui.components.Presence.RiwayatP
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.presensi.viewmodel.PresenceViewModel
import com.rie.simpaduapp.base.Result

//@Composable
//fun HistoryPresence(
//    modifier: Modifier = Modifier,
//    viewModel: PresenceViewModel = viewModel(
//        factory = ViewModelFactory(LocalContext.current)
//    ),
//) {
//    val namaMkResult = viewModel.pertemuan.collectAsState()
//
//    when (val nama_mk = namaMkResult.value) {
//        is Result.Loading -> {
//            // Tampilkan indikator loading jika diperlukan
//        }
//        is Result.Success -> {
////            val presensiHList = pertemuan.data
//            LazyColumn(
//                modifier = modifier
//                    .fillMaxSize()
//                    .background(Color(0xFFFFFFFF))
//                    .padding(horizontal = 16.dp)
//            ) {
//                items(presensiHList) {riwayat->
//                    nama_mk?.let {
////                        RiwayatP(pertemuan = riwayat.pertemuan)
//                    }
//                }
//            }
//        }
//        is Result.Error<*> -> {
//            // Tangani keadaan error jika diperlukan
//        }
//    }
//
//
//
//    LaunchedEffect(Unit) {
//        viewModel.getRiwayatPresence()
//    }
//
//}