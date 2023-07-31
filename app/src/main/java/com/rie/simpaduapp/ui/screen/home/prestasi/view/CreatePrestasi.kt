package com.rie.simpaduapp.ui.screen.home.prestasi.view

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.home.prestasi.viewmodel.PrestasiViewModel
import com.rie.simpaduapp.base.Result

@Composable
fun CreatePrestasi(modifier: Modifier = Modifier, navigateBack: () -> Unit,
                   viewModel: PrestasiViewModel = viewModel(
                       factory = ViewModelFactory(LocalContext.current)
                   ),
                   ) {
    val nama_prestasi = remember { mutableStateOf("") }
    val tingkatan_lomba = remember { mutableStateOf("") }
    val jenis_peserta = remember { mutableStateOf("") }
    val jumlah_peserta = remember { mutableStateOf("") }
    val capaian_prestasi = remember { mutableStateOf("") }
    val tanggal_lomba = remember { mutableStateOf("") }


    val nama_prestasiInput = nama_prestasi.value
    val tingkatan_lombaInput = tingkatan_lomba.value
    val jenis_pesertaInput = jenis_peserta.value
    val jumlah_pesertaInput = jumlah_peserta.value
    val capaian_prestasiInput = capaian_prestasi.value
    val tanggal_lombaInput = tanggal_lomba.value

    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Tambah Prestasi") },
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
                    Text(text = "Masukkan Prestasi")
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = nama_prestasiInput,
                        onValueChange = {nama_prestasi.value = it },
                        label = { Text(text = "Nama Prestasi") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = tingkatan_lombaInput,
                        onValueChange = { tingkatan_lomba.value = it },
                        label = { Text(text = "Tingkatan Lomba") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = jenis_pesertaInput,
                        onValueChange = {jenis_peserta.value = it },
                        label = { Text(text = "Jenis Peserta") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = jumlah_pesertaInput,
                        onValueChange = { jumlah_peserta.value = it },
                        label = { Text(text = "Jumlah Peserta") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = capaian_prestasiInput,
                        onValueChange = { capaian_prestasi.value = it },
                        label = { Text(text = "Capaian Prestasi") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = tanggal_lombaInput,
                        onValueChange = { tanggal_lomba.value = it },
                        label = { Text(text = "Tanggal lomba (YY-MM-DD)") },
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(100.dp)),
                        onClick = {
                            viewModel.CreatePrestasi(nama_prestasiInput, tingkatan_lombaInput, jenis_pesertaInput, jumlah_pesertaInput, capaian_prestasiInput, tanggal_lombaInput)
                                .observe(lifecycleOwner, {
                                    when (it) {
                                        is Result.Loading -> {
                                            // Handle loading state if needed
                                        }
                                        is Result.Success -> {
                                            Toast.makeText(context, it.data.message, Toast.LENGTH_LONG).show()
                                        }
                                        is Result.Error -> {
                                            Toast.makeText(context, "Silahkan masukkan kembali prestasi anda", Toast.LENGTH_LONG).show()
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