package com.rie.simpaduapp.ui.screen.profile.view

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.profile.viewmodel.ProfileViewModel
import com.rie.simpaduapp.repository.Result
import java.util.*
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun EditProfile(modifier: Modifier = Modifier, navigateBack: () -> Unit,
                viewModel: ProfileViewModel = viewModel(
                    factory = ViewModelFactory(LocalContext.current)
                ),
                ) {
    val nama = remember { mutableStateOf("") }
    val tempat_lahir = remember { mutableStateOf("") }
    val no_hp = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val alamat = remember { mutableStateOf("") }
    val nama_ibu = remember { mutableStateOf("") }
    val nama_ayah = remember { mutableStateOf("") }
    val kecamatan = remember { mutableStateOf("") }
    val kelurahan = remember { mutableStateOf("") }

    val namaInput = nama.value
    val tempat_lahirInput= tempat_lahir.value
    val no_hpInput= no_hp.value
    val emailInput= email.value
    val alamatInput= alamat.value
    val nama_ibuInput= nama_ibu.value
    val nama_ayahInput= nama_ayah.value
    val kecamatanInput= kecamatan.value
    val kelurahanInput= kelurahan.value
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val activity = LocalContext.current as? AppCompatActivity

    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Edit Profile") },
                contentColor = Color.White,
                elevation = 10.dp,
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            imageVector = Icons.Default.NavigateBefore,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = {it
            LazyColumn(
                modifier = Modifier.fillMaxHeight().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .padding(vertical = 8.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Image(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp),
                            painter = painterResource(id = R.drawable.profiluser),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_edit),
                            contentDescription = "Icon",
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Ganti Photo Profil",
                            fontSize = 11.sp,
                            color = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = nama.value,
                        onValueChange = { nama.value = it },
                        label = { Text(text = "Nama Lengkap") }
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = tempat_lahir.value,
                        onValueChange = { tempat_lahir.value = it },
                        label = { Text(text = "Tempat Lahir") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = no_hp.value,
                        onValueChange = { no_hp.value = it },
                        label = { Text(text = "No Handphone") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = email.value,
                        onValueChange = { email.value = it },
                        label = { Text(text = "Email") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = alamat.value,
                        onValueChange = { alamat.value = it },
                        label = { Text(text = "Alamat Lengkap") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = nama_ibu.value,
                        onValueChange = { nama_ibu.value = it },
                        label = { Text(text = "Nama ibu") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = nama_ayah.value,
                        onValueChange = { nama_ayah.value = it },
                        label = { Text(text = "Nama ayah") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = kecamatan.value,
                        onValueChange = { kecamatan.value = it },
                        label = { Text(text = "Kecamatan") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = kelurahan.value,
                        onValueChange = { kelurahan.value = it },
                        label = { Text(text = "Kelurahan") }
                    )

                    Spacer(modifier = modifier.padding(20.dp))
                    Button(
                        modifier = modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(100.dp)),
                        onClick = {
                            viewModel.updateProfile(
                                namaInput, tempat_lahirInput, no_hpInput, emailInput,
                              alamatInput, nama_ibuInput, nama_ayahInput, kecamatanInput, kelurahanInput
                            ).observe(lifecycleOwner, {
                                when (it) {
                                    is Result.Loading -> {
                                        // Handle loading state if needed
                                    }
                                    is Result.Success -> {
//                                    changePhoto(context)
                                        Toast.makeText(context, it.data.message, Toast.LENGTH_LONG).show()
                                    }
                                    is Result.Error -> {
                                        Toast.makeText(context, "Terjadi kesalahan saat update profile", Toast.LENGTH_LONG).show()
                                    }
                                }
                            }
                            )

                        }
                    ) {
                        Text(text = "SIMPAN PERUBAHAN")
                    }
                    Spacer(modifier = modifier.padding(50.dp))
                }
            }
        }
    )
}