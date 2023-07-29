package com.rie.simpaduapp.ui.components.Presence

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import com.rie.simpaduapp.R

@Composable
fun RiwayatP() {
    RiwayatPContent()
}

@Composable
fun RiwayatPContent(
    modifier: Modifier = Modifier
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
            shape = RoundedCornerShape(8.dp) ,
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Pertemuan 1",
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                    Text(
                        text = "Keterampilan Komputer",
                        color = Color.Gray,
                        fontSize = 17.sp,
                        fontWeight = Bold
                    )
                    Text(
                        text = "Hadir",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(top = 7.dp)
                    )
                }
            }
        }
    }
}
