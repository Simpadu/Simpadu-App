package com.rie.simpaduapp.ui.components.Presence

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier

@Composable
fun RiwayatP(
    modifier: Modifier = Modifier,
    nama_matkul: String,
    status: String,
    pertemuan: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Pertemuan: ",
                            color = Color.Gray,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = pertemuan,
                            color = Color.Gray,
                            fontSize = 15.sp,

                            )
                    }
                    Text(
                        text = nama_matkul,
                        color = Color.Gray,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Status: ",
                            color = Color.Gray,
                            fontSize = 13.sp,

                            )
                        Text(
                            text = status,
                            color = Color.Gray,
                            fontSize = 13.sp,

                            )
                    }
                }
            }
        }
    }
}
