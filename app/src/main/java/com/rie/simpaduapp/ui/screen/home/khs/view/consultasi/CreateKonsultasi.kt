//package com.rie.simpaduapp.ui.screen.home.khs.view.consultasi
//
//import com.rie.simpaduapp.ui.screen.home.khs.viewmodel.KhsViewModel
//
//import android.widget.Toast
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.unit.dp
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalLifecycleOwner
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.rie.simpaduapp.R
//import com.rie.simpaduapp.ui.screen.ViewModelFactory
//import com.rie.simpaduapp.ui.screen.profile.viewmodel.ProfileViewModel
//import com.rie.simpaduapp.base.Result
//
//@Composable
//fun CreateKonsultasi(modifier: Modifier = Modifier, navigateBack: () -> Unit,
//                     viewModel: KhsViewModel = viewModel(
//                         factory = ViewModelFactory(LocalContext.current)
//                     ),) {
//    val keterangan = remember { mutableStateOf("") }
//    val keteranganInput = keterangan.value
//    val lifecycleOwner = LocalLifecycleOwner.current
//    val context = LocalContext.current
//
//    Scaffold(
//        modifier = modifier,
//        topBar = {
//            TopAppBar(
//                title = { Text(text = "Tambah Konsultasi") },
//                contentColor = Color.White,
//                elevation = 10.dp,
//                navigationIcon = {
//                    IconButton(onClick =  navigateBack) {
//                        Icon(
//                            painter = painterResource(R.drawable.baseline_navigate_before_24),
//                            contentDescription = "Back"
//                        )
//                    }
//                }
//            )
//        },
//        content = {it
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp)
//            ) {
//                item {
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Text(text = "Masukkan Keterangan")
//                    OutlinedTextField(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 8.dp),
//                        value = keteranganInput,
//                        onValueChange = { keterangan.value = it },
//                        label = { Text(text = "Keterangan") },
//                    )
//                }
//                item {
//                    Spacer(modifier = Modifier.height(20.dp))
//                    Button(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .clip(shape = RoundedCornerShape(100.dp)),
//                        onClick = {
//                            viewModel.CreateKonsultasi(keteranganInput).observe(lifecycleOwner, {
//                                when (it) {
//                                    is Result.Loading -> {
//                                    }
//                                    is Result.Success -> {
//                                        Toast.makeText(context, it.data.message, Toast.LENGTH_LONG).show()
//                                    }
//                                    is Result.Error -> {
//                                        Toast.makeText(context, "silahkan masukkan kembali keterangan anda", Toast.LENGTH_LONG).show()
//                                    }
//                                }
//                            })
//                        }
//                    ) {
//                        Text(text = "KONFIRMASI")
//                    }
//                    Spacer(modifier = Modifier.height(70.dp))
//                }
//
//            }
//        }
//    )
//}
