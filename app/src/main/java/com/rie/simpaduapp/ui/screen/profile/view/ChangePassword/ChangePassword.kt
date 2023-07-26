package com.rie.simpaduapp.ui.screen.profile.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.rie.simpaduapp.R

@Composable
fun ChangePassword(modifier: Modifier = Modifier, navigateBack: () -> Unit) {
    val income1 = remember { mutableStateOf("") }
    val income2 = remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Ganti Password") },
                contentColor = Color.White,
                elevation = 10.dp,
                navigationIcon = {
                    IconButton(onClick =  navigateBack) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_navigate_before_24),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = {it
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Masukkan NIM")
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    value = income1.value,
                    onValueChange = { income1.value = it },
                    label = { Text(text = "NIM") },
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Masukkan Email")
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    value = income2.value,
                    onValueChange = { income2.value = it },
                    label = { Text(text = "Email") },
                )
                Spacer(modifier = modifier.padding(20.dp))
                Button(
                    modifier = modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(100.dp)),
                    onClick = { /* Handle button click */ }
                ) {
                    Text(text = "KONFIRMASI")
                }
            }
        }
    )
}
