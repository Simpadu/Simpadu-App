package com.rie.simpaduapp.ui.screen.home.jadwal.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rie.simpaduapp.ui.components.Category.Jadwal.Jadwal
import com.rie.simpaduapp.ui.components.Category.Magang.Magang

@Composable
fun JadwalScreen() {
    JadwalScreenContent()
}

@Composable
fun JadwalScreenContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 16.dp),
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Jadwal()
    }
}