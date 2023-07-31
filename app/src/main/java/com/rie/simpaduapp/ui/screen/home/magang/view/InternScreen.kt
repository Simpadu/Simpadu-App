package com.rie.simpaduapp.ui.screen.home.magang.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.R
import com.rie.simpaduapp.base.Result
import com.rie.simpaduapp.ui.components.Category.Krs.KRS
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.home.magang.viewmodel.InternViewModel


@Composable
fun InternScreen(
    modifier: Modifier = Modifier, navigateBack: () -> Unit,
    viewModel: InternViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {
    val nama = remember { mutableStateOf("") }
    val judul = remember { mutableStateOf("") }
    val tempat_magang = remember { mutableStateOf("") }


    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current


    val namaInput = nama.value
    val judulInput = judul.value
    val tempat_magangInput = tempat_magang.value


    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Magang") },
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Masukkan Magang")
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = namaInput,
                        onValueChange = { nama.value = it },
                        label = { Text(text = "Nama") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = judulInput,
                        onValueChange = { judul.value = it },
                        label = { Text(text = "Judul") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value =tempat_magangInput,
                        onValueChange = { tempat_magang.value = it },
                        label = { Text(text = "Tempat Magang") },
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(100.dp)),
                        onClick = {
                            viewModel.updateMagang(
                                namaInput,judulInput,tempat_magangInput
                            ).observe(lifecycleOwner, {
                                when (it) {
                                    is Result.Loading -> {
                                    }
                                    is Result.Success -> {
                                        Toast.makeText(context, it.data.message, Toast.LENGTH_LONG).show()
                                    }
                                    is Result.Error -> {
                                        Toast.makeText(context, "silahkan masukkan kembali inputan magang anda", Toast.LENGTH_LONG).show()
                                    }
                                }
                            })
                        }
                    ) {
                        Text(text = "KONFIRMASI")
                    }
                    Spacer(modifier = Modifier.height(70.dp))
                }

            }
        }
    )
}

