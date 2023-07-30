package com.rie.simpaduapp.ui.components.Presence

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.common.UiState
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.presensi.viewmodel.PresenceViewModel
import kotlinx.coroutines.launch

@Composable
fun CustomAlertDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    id: Int,
    viewModel: PresenceViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {
    // State to hold the user's status
    var status by remember { mutableStateOf("") }

    if (showDialog) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnClickOutside = false
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Input field for status
                TextField(
                    value = status,
                    onValueChange = { status = it },
                    label = { Text("Status (Hadir/H) or (Sakit/I):") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            // Call the createPresensiById function within a coroutine
                            viewModel.viewModelScope.launch {
                                viewModel.createPresensiById(id, status)
                            }
                            onDismiss()
                        }
                    ) {
                        Text("Hadir")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = {
                            // Call the createPresensiById function within a coroutine
                            viewModel.viewModelScope.launch {
                                viewModel.createPresensiById(id, status)
                            }
                            onDismiss()
                        }
                    ) {
                        Text("Sakit")
                    }
                }
            }
        }
    }
}
