package com.rie.simpaduapp.ui.screen.auth

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.rie.simpaduapp.R
import com.rie.simpaduapp.data.Preferences
import com.rie.simpaduapp.ui.components.LoginInput
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.auth.viewmodel.LoginViewModel
import com.rie.simpaduapp.ui.components.BtnLogin
import com.rie.simpaduapp.base.Result



@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: LoginViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val nimInput = viewModel.nimState.observeAsState(initial = "")
    val passwordInput = viewModel.passwordState.observeAsState(initial = "")
    val nim = nimInput.value
    val password = passwordInput.value
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.White
    ) { it
        val context = LocalContext.current
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
            LoginInput(
                nim = nim,
                password = password,
                onNimChange = viewModel::onNimChange,
                onPasswordChange = viewModel::onPasswordChange,
                navHostController = navHostController
            )
            Spacer(modifier = Modifier.height(30.dp))
            BtnLogin(
                navHostController = navHostController,
                onClick = {
                    viewModel.login(nim, password).observe(lifecycleOwner, {
                        when(it) {
                          is Result.Loading -> {}
                            is Result.Success -> {
                                val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                                Preferences.saveAccessToken(it.data.accessToken, sharedPreferences)
                                Preferences.setLoggedIn(sharedPreferences, true)
                                navHostController.popBackStack()
                                navHostController.navigate("home")
                            }
                            is Result.Error -> {
                                Toast.makeText(context, "Masukkan Username dan Password yang benar", Toast.LENGTH_LONG).show()
                            }
                            else -> {}
                        }
                    })
                }
            )


        }
    }
}

