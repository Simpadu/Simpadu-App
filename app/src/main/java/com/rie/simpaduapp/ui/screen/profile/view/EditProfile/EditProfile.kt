package com.rie.simpaduapp.ui.screen.profile.view

import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.profile.viewmodel.ProfileViewModel
import com.rie.simpaduapp.base.Result
import java.util.*

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

    var imageUser by remember { mutableStateOf("https://www.citypng.com/public/uploads/preview/free-round-flat-male-portrait-avatar-user-icon-png-11639648873oplfof4loj.png") }
    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }

    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            selectedImageUri.value = uri
        }
    }

    val isNamaModified = remember { mutableStateOf(false) }
    val isTempatLahirModified = remember { mutableStateOf(false) }
    val isno_hpModified = remember { mutableStateOf(false) }
    val isno_emailModified = remember { mutableStateOf(false) }
    val isalamatModified = remember { mutableStateOf(false) }
    val isnama_ibuModified = remember { mutableStateOf(false) }
    val isnama_ayahModified = remember { mutableStateOf(false) }
    val iskecamatanModified = remember { mutableStateOf(false) }
    val iskelurahanModified = remember { mutableStateOf(false) }

    viewModel.foto_profil.collectAsState().value.let {
        when (it) {
            is Result.Loading -> {
                // Handle loading state if needed
            }
            is Result.Success -> {
                Toast.makeText(context, it.data.message, Toast.LENGTH_LONG).show()
            }
            is Result.Error -> {
                Toast.makeText(context, "Terjadi kesalahan saat update profile", Toast.LENGTH_LONG).show()
            }
        }
    }

//    val isBiodataUpdated = (namaInput != "" || tempat_lahirInput != "" || no_hpInput != "" || emailInput != "" ||
//            alamatInput != "" || nama_ibuInput != "" || nama_ayahInput != "" || kecamatanInput != "" || kelurahanInput != "")
//
//    val isPhotoUpdated = selectedImageUri.value != null

    val isBiodataUpdated = (namaInput.isNotBlank() || tempat_lahirInput.isNotBlank() || no_hpInput.isNotBlank() || emailInput.isNotBlank() ||
            alamatInput.isNotBlank() || nama_ibuInput.isNotBlank() || nama_ayahInput.isNotBlank() || kecamatanInput.isNotBlank() || kelurahanInput.isNotBlank())

    val isPhotoUpdated = selectedImageUri.value != null


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
                            painter = rememberImagePainter(
                                data = selectedImageUri.value?.toString() ?: imageUser,
                                builder = {
                                    transformations(CircleCropTransformation())
                                }
                            ),
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
                        ClickableText(
                            text = AnnotatedString("Ganti Foto Profil"),
                            onClick = { galleryLauncher.launch("image/*") }
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = namaInput,
                        onValueChange = { nama.value = it
                            isNamaModified.value = true
                                        },
                        label = { Text(text = "Nama Lengkap") }
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = tempat_lahir.value,
                        onValueChange = { tempat_lahir.value = it
                            isTempatLahirModified.value = true
                                        },
                        label = { Text(text = "Tempat Lahir") },
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = no_hp.value,
                        onValueChange = { no_hp.value = it
                            isno_hpModified.value = true
                                        },
                        label = { Text(text = "No Handphone") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = email.value,
                        onValueChange = { email.value = it
                            isno_emailModified.value = true},
                        label = { Text(text = "Email") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = alamat.value,
                        onValueChange = { alamat.value = it
                            isalamatModified.value = true},
                        label = { Text(text = "Alamat Lengkap") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = nama_ibu.value,
                        onValueChange = { nama_ibu.value = it
                            isnama_ibuModified.value = true},
                        label = { Text(text = "Nama ibu") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = nama_ayah.value,
                        onValueChange = { nama_ayah.value = it
                            isnama_ayahModified.value = true},
                        label = { Text(text = "Nama ayah") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = kecamatan.value,
                        onValueChange = { kecamatan.value = it
                            iskecamatanModified.value = true},
                        label = { Text(text = "Kecamatan") }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        value = kelurahan.value,
                        onValueChange = { kelurahan.value = it
                            iskelurahanModified.value = true},
                        label = { Text(text = "Kelurahan") }
                    )

                    Spacer(modifier = modifier.padding(20.dp))
                    Button(
                        modifier = modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(100.dp)),
                        onClick = {
                            if (isPhotoUpdated) {
                                selectedImageUri.value?.let { uri ->
                                    context.contentResolver.openInputStream(uri)?.let { inputStream ->
                                        viewModel.changePhoto(inputStream)
                                    }
                                }
                            }

                            if (isBiodataUpdated) {
                                viewModel.updateProfile(
                                    namaInput, tempat_lahirInput, no_hpInput, emailInput,
                                    alamatInput, nama_ibuInput, nama_ayahInput, kecamatanInput, kelurahanInput
                                ).observe(lifecycleOwner, { result ->
                                    when (result) {
                                        is Result.Loading -> {

                                        }
                                        is Result.Success -> {

                                            Toast.makeText(context, result.data.message, Toast.LENGTH_LONG).show()
                                        }
                                        is Result.Error -> {

                                            Toast.makeText(context, "Terjadi kesalahan saat update profile", Toast.LENGTH_LONG).show()
                                        }
                                    }
                                })
                            } else {
                                Toast.makeText(context, "Data mahasiswa tidak boleh kosong!", Toast.LENGTH_LONG).show()
                            }
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
