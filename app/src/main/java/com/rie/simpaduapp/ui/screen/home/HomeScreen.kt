package com.rie.simpaduapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.rie.simpaduapp.base.MahasiswaResponse
import com.rie.simpaduapp.ui.common.UiState
import com.rie.simpaduapp.ui.components.BannerItem
import com.rie.simpaduapp.ui.components.Category
import com.rie.simpaduapp.ui.components.Home.Ipk
import com.rie.simpaduapp.ui.components.Home.Minggu
import com.rie.simpaduapp.ui.components.Home.Status
import com.rie.simpaduapp.ui.components.Home.Tsks
import com.rie.simpaduapp.ui.components.HomeSection
import com.rie.simpaduapp.ui.components.navigation.BottomBar
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import kotlinx.coroutines.flow.collect

@Composable
fun HomeScreen(
    navController: NavHostController,

) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
//                    User()
                        Text(text = "Simpadu")
                },
                backgroundColor = Color.White,
                elevation = 2.dp,
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        },
        bottomBar = {
            BottomBar(
                modifier = Modifier,
                navController = navController
            )
        },
    ) {
        it
        Column(
            modifier = Modifier
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            BannerItem()
            Spacer(modifier = Modifier.height(20.dp))
            HomeSection(
                title = "menu",
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Category(onItemClick = { clickedText ->
                            println("Clicked: $clickedText")
                        })
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            HomeSection(
                title = "status",
                content = { Minggu() }
            )
            HomeSection(
                title = "status",
                content = { Status() }
            )
            HomeSection(
                title = "status",
                content = { Tsks() }
            )
            HomeSection(
                title = "status",
                content = { Ipk() }
            )
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}


