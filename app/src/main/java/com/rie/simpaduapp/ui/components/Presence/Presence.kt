package com.rie.simpaduapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.rie.simpaduapp.ui.components.Presence.CustomAlertDialog

@Composable
fun Kehadiran(
    modifier: Modifier = Modifier,
    id: Int,
    nama_mk: String,
    masih_dibuka: Boolean
) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .clickable { showDialog = true },
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
                        text = nama_mk,
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                    Text(
                        text = if (masih_dibuka) "Dibuka" else "Tutup",
                        color = Color.Gray,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        CustomAlertDialog(
            showDialog = showDialog,
            onDismiss = { showDialog = false },
            id = id // Pass the "id" to CustomAlertDialog
        )
    }
}
