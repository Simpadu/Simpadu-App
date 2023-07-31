package com.rie.simpaduapp.ui.screen.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.ui.common.UiState
import com.rie.simpaduapp.ui.screen.ViewModelFactory

@Composable
fun User(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    )
){
    var nama by remember { mutableStateOf("") }

    viewModel.nama.collectAsState(initial = UiState.Loading).value.let { user ->
        when (user) {
            is UiState.Loading -> {
               viewModel.getUserMahasiswa()
            }
            is UiState.Success -> {
                nama = user.data.nama
            }
            else -> {
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = nama,
            color = Color.Gray,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }

}