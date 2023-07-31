package com.rie.simpaduapp.ui.components.Category.Ukt

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.text.font.FontWeight.Companion.Bold

@Composable
fun RiwayatPembayaran(
    modifier: Modifier = Modifier,
    status: String,
    tanggal_registrasi: String,
    tahun_akademik: String,

    ) {
    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = tahun_akademik.toString(),
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                    Text(
                        text = status,
                        color = Color.Gray,
                        fontSize = 17.sp,
                        fontWeight = Bold
                    )
                    Text(
                        text = tanggal_registrasi.toString(),
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(top = 7.dp)
                    )
                }
            }
        }
    }

}

