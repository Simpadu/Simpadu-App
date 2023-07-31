package com.rie.simpaduapp.ui.screen.home.ukt.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.common.UiState
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.home.ukt.viewmodel.UktViewModel
import com.rie.simpaduapp.base.Result

@Composable
fun UktP(modifier: Modifier = Modifier,
         viewModel: UktViewModel = viewModel(
             factory = ViewModelFactory(LocalContext.current)
         ),
) {
    var virtual_akun by remember { mutableStateOf("14578999") }
    var status_bebas_masalah by remember { mutableStateOf("14578999") }
    var catatan by remember { mutableStateOf("14578999") }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(8.dp) ,
            elevation = 8.dp
        ) {
            viewModel.virtual_akun.collectAsState(initial = UiState.Loading).value.let { user ->
                when (user) {
                    is UiState.Loading -> {
                        viewModel.getUktAll()
                    }
                    is UiState.Success -> {
                        virtual_akun = user.data.virtual_akun.toString()
                        status_bebas_masalah= user.data.status_bebas_masalah.toString()
                       catatan= user.data.catatan.toString()
                    }
                    else -> {
                    }
                }
            }

            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Virtual Akun: ",
                            color = Color.Gray,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = virtual_akun,
                            color = Color.Gray,
                            fontSize = 15.sp,

                        )
                    }
                    Text(
                        text = status_bebas_masalah,
                        color = Color.Gray,
                        fontSize = 17.sp,
                        fontWeight = Bold
                    )
                    Text(
                        text = catatan,
                        color = Color.Gray,
                        fontSize = 12.sp

                    )
                }
            }
        }
    }
}
