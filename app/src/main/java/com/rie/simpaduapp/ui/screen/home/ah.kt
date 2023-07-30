package com.rie.simpaduapp.ui.screen.home



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
import com.rie.simpaduapp.ui.screen.home.HomeViewModel

@Composable
fun ah(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {
    var nama by remember { mutableStateOf("Temansawit Guest") }
    Column(
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp
        ) {
            viewModel.nama.collectAsState(initial = com.rie.simpaduapp.ui.common.UiState.Loading).value.let { user ->
                when (user) {
                    is com.rie.simpaduapp.ui.common.UiState.Loading -> {
                        viewModel.getNama()
                    }
                    is com.rie.simpaduapp.ui.common.UiState.Success -> {
                        nama = user.data.nama.toString()
                    }
                    else -> {
                        // Handle other cases here if necessary
                        // For example, you might want to show an error message or take other actions.
                    }
                }
            }
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Pertemuan",
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                    Text(
                        text = nama,
                        color = Color.Gray,
                        fontSize = 17.sp,
                        fontWeight = Bold
                    )
                }
            }
        }
    }
}
