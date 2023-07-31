package com.rie.simpaduapp.ui.screen.home.prestasi.view

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.components.Category.Prestasi.Prestasi
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.home.prestasi.viewmodel.PrestasiViewModel
import com.rie.simpaduapp.base.Result
import kotlinx.coroutines.delay

@Composable
fun ShowLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun AwardsScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    viewModel: PrestasiViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {
    val context = LocalContext.current
    val prestasiResult = viewModel.nama_prestasi.collectAsState()

    // State for showing the deletion message Snackbar
    var deleteMessageState by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Prestasi") },
                contentColor = Color.White,
                elevation = 10.dp,
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_navigate_before_24),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },

        content = {it
            when (val result = prestasiResult.value) {
                is Result.Loading -> {
                    // Show loading indicator while data is being fetched
                    ShowLoading()
                }
                is Result.Success -> {
                    val prestasiList = result.data
                    LazyColumn(
                        modifier = modifier
                            .fillMaxSize()
                            .background(Color(0xFFFFFFFF))
                            .padding(horizontal = 16.dp)
                    ) {
                        items(prestasiList) { prestasi ->
                            Prestasi(
                                nama_prestasi = prestasi.nama_prestasi,
                                onDeleteClick = {
                                    viewModel.deletePrestasi(prestasi.id)
                                    deleteMessageState = true
                                }
                            )
                        }
                    }
                }
                is Result.Error<*> -> {

                }
            }
            LaunchedEffect(Unit) {
                viewModel.getPrestasi()
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val intent = Intent(context, CreatePrestasiActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.padding(16.dp),
                backgroundColor = Color(0xFF6FF9FF)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                )
            }
        }
    )

    if (deleteMessageState) {
        LaunchedEffect(deleteMessageState) {
            delay(3000)
            deleteMessageState = false
        }
        Snackbar(
            modifier = Modifier.padding(16.dp),
            action = {
                Button(onClick = { deleteMessageState = false }) {
                    Text(text = "OK")
                }
            }
        ) {
            Text(text = "Prestasi berhasil dihapus!")
        }
    }
}
