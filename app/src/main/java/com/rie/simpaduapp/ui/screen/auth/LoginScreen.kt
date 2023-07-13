package com.rie.simpaduapp.ui.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rie.simpaduapp.R


@Composable
fun LoginScreen() {
    val currentUsername = remember { mutableStateOf("") }
    val currentPassword = remember { mutableStateOf("") }
    val currentPasswordVisibility = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.White
    ) { it
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,

        ) {
            Box(
                modifier = Modifier
                    .size(66.dp)
                    .background(Color.White, shape = MaterialTheme.shapes.medium)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.Center)
                )
            }
            Text(
                text = stringResource(id = R.string.wlcome),
                color = Color.Black,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(top = 28.dp)
            )

            Text(
                text = stringResource(id = R.string.login),
                color = Color.Gray,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                value = currentUsername.value,
                label = { Text(text = "Username") },
                onValueChange = { currentUsername.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Username Icon"
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                value = currentPassword.value,
                label = { Text(text = "Password") },
                onValueChange = { currentPassword.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Key,
                        contentDescription = "Password Icon"
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                        currentPasswordVisibility.value = !currentPasswordVisibility.value
                    }) {
                        Icon(
                            imageVector = if (currentPasswordVisibility.value)
                                Icons.Filled.Visibility
                            else
                                Icons.Filled.VisibilityOff,
                            contentDescription = "Toggle Visibility"
                        )
                    }
                },
                visualTransformation = if (currentPasswordVisibility.value)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(100.dp))
            ) {
                Text(
                    text = stringResource(id = R.string.btn_login),
                    color = Color.White,
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}
