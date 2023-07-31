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
import com.rie.simpaduapp.ui.screen.home.wisuda.viewmodel.WisudaViewModel


@Composable
fun GraduationScreen(
    modifier: Modifier = Modifier, navigateBack: () -> Unit,
    viewModel: WisudaViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {
    val pengalaman_organisasi = remember { mutableStateOf("") }
    val pengalaman_pelatihan = remember { mutableStateOf("") }
    val pengalaman_prestasi = remember { mutableStateOf("") }
    val nama_ayah = remember { mutableStateOf("") }
    val alamat_ortu = remember { mutableStateOf("") }
    val judul_tugas_akhir = remember { mutableStateOf("") }
    val  tanggal_ujian = remember { mutableStateOf("") }

    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current


    val pengalaman_organisasiInput = pengalaman_organisasi.value
    val pengalaman_pelatihanInput = pengalaman_pelatihan.value
    val pengalaman_prestasiInput = pengalaman_prestasi.value
    val nama_ayahInput = nama_ayah.value
    val alamat_ortuInput = alamat_ortu.value
    val judul_tugas_akhirInput = judul_tugas_akhir.value
    val tanggal_ujianInput = tanggal_ujian.value


    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Wisuda") },
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
                    Text(text = "Masukkan Wisuda")
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = pengalaman_organisasiInput,
                        onValueChange = { pengalaman_organisasi.value = it },
                        label = { Text(text = "Pengalaman Organisasi") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = pengalaman_pelatihanInput,
                        onValueChange = { pengalaman_pelatihan.value = it },
                        label = { Text(text = "Pengalaman Pelatihan") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value =pengalaman_prestasiInput,
                        onValueChange = { pengalaman_prestasi.value = it },
                        label = { Text(text = "Pengalaman Prestasi") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = nama_ayahInput,
                        onValueChange = { nama_ayah.value = it },
                        label = { Text(text = "Nama Ayah") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = alamat_ortuInput,
                        onValueChange = { alamat_ortu.value = it },
                        label = { Text(text = "Alamat orang tua") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = judul_tugas_akhirInput,
                        onValueChange = {judul_tugas_akhir.value = it },
                        label = { Text(text = "Judul tugas akhir") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = tanggal_ujianInput,
                        onValueChange = { tanggal_ujian.value = it },
                        label = { Text(text = "Tanggal ujian") },
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(100.dp)),
                        onClick = {
                            viewModel.updateWisuda(pengalaman_organisasiInput,pengalaman_pelatihanInput,pengalaman_prestasiInput,nama_ayahInput,
                                alamat_ortuInput, judul_tugas_akhirInput,tanggal_ujianInput).observe(lifecycleOwner, {
                                when (it) {
                                    is Result.Loading -> {
                                    }
                                    is Result.Success -> {
                                        Toast.makeText(context, it.data.message, Toast.LENGTH_LONG).show()
                                    }
                                    is Result.Error -> {
                                        Toast.makeText(context, "silahkan masukkan kembali keterangan anda", Toast.LENGTH_LONG).show()
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

